@Test public void testAddedRowsTwoTables() throws SQLException {
  final Connection con=((DBCPService)runner.getControllerService("dbcp")).getConnection();
  Statement stmt=con.createStatement();
  try {
    stmt.execute("drop table TEST_QUERY_DB_TABLE");
  }
 catch (  final SQLException sqle) {
  }
  try {
    stmt.execute("drop table TEST_QUERY_DB_TABLE2");
  }
 catch (  final SQLException sqle) {
  }
  stmt.execute("create table TEST_QUERY_DB_TABLE (id integer not null, name varchar(100), scale float, created_on timestamp, bignum bigint default 0)");
  stmt.execute("insert into TEST_QUERY_DB_TABLE (id, name, scale, created_on) VALUES (0, 'Joe Smith', 1.0, '1962-09-23 03:23:34.234')");
  stmt.execute("insert into TEST_QUERY_DB_TABLE (id, name, scale, created_on) VALUES (1, 'Carrie Jones', 5.0, '2000-01-01 03:23:34.234')");
  stmt.execute("insert into TEST_QUERY_DB_TABLE (id, name, scale, created_on) VALUES (2, NULL, 2.0, '2010-01-01 00:00:00')");
  runner.setProperty(QueryDatabaseTableRecord.TABLE_NAME,"TEST_QUERY_DB_TABLE");
  runner.setIncomingConnection(false);
  runner.setProperty(QueryDatabaseTableRecord.MAX_VALUE_COLUMN_NAMES,"ID");
  runner.setProperty(QueryDatabaseTableRecord.MAX_ROWS_PER_FLOW_FILE,"2");
  runner.run();
  runner.assertAllFlowFilesTransferred(QueryDatabaseTableRecord.REL_SUCCESS,2);
  MockFlowFile flowFile=runner.getFlowFilesForRelationship(QueryDatabaseTableRecord.REL_SUCCESS).get(0);
  assertEquals("TEST_QUERY_DB_TABLE",flowFile.getAttribute(QueryDatabaseTableRecord.RESULT_TABLENAME));
  assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
  flowFile.assertAttributeEquals("record.count","2");
  flowFile=runner.getFlowFilesForRelationship(QueryDatabaseTableRecord.REL_SUCCESS).get(1);
  assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
  flowFile.assertAttributeEquals("record.count","1");
  runner.clearTransferState();
  stmt.execute("create table TEST_QUERY_DB_TABLE2 (id integer not null, name varchar(100), scale float, created_on timestamp, bignum bigint default 0)");
  stmt.execute("insert into TEST_QUERY_DB_TABLE2 (id, name, scale, created_on) VALUES (0, 'Joe Smith', 1.0, '1962-09-23 03:23:34.234')");
  stmt.execute("insert into TEST_QUERY_DB_TABLE2 (id, name, scale, created_on) VALUES (1, 'Carrie Jones', 5.0, '2000-01-01 03:23:34.234')");
  stmt.execute("insert into TEST_QUERY_DB_TABLE2 (id, name, scale, created_on) VALUES (2, NULL, 2.0, '2010-01-01 00:00:00')");
  runner.setProperty(QueryDatabaseTableRecord.TABLE_NAME,"TEST_QUERY_DB_TABLE2");
  runner.setProperty(QueryDatabaseTableRecord.MAX_ROWS_PER_FLOW_FILE,"0");
  runner.run();
  runner.assertAllFlowFilesTransferred(QueryDatabaseTableRecord.REL_SUCCESS,1);
  flowFile=runner.getFlowFilesForRelationship(QueryDatabaseTableRecord.REL_SUCCESS).get(0);
  assertEquals("TEST_QUERY_DB_TABLE2",flowFile.getAttribute(QueryDatabaseTableRecord.RESULT_TABLENAME));
  assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
  flowFile.assertAttributeEquals("record.count","3");
  runner.clearTransferState();
  stmt.execute("insert into TEST_QUERY_DB_TABLE2 (id, name, scale, created_on) VALUES (3, 'Mary West', 15.0, '2000-01-01 03:23:34.234')");
  runner.run();
  runner.assertAllFlowFilesTransferred(QueryDatabaseTableRecord.REL_SUCCESS,1);
  flowFile=runner.getFlowFilesForRelationship(QueryDatabaseTableRecord.REL_SUCCESS).get(0);
  assertEquals(flowFile.getAttribute("maxvalue.id"),"3");
  flowFile.assertAttributeEquals("record.count","1");
  runner.clearTransferState();
  runner.run();
  runner.assertAllFlowFilesTransferred(QueryDatabaseTableRecord.REL_SUCCESS,0);
  runner.clearTransferState();
}
