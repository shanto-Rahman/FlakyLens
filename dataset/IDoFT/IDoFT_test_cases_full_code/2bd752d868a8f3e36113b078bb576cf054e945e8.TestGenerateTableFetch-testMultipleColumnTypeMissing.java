@Test public void testMultipleColumnTypeMissing() throws ClassNotFoundException, SQLException, InitializationException, IOException {
  final Connection con=((DBCPService)runner.getControllerService("dbcp")).getConnection();
  Statement stmt=con.createStatement();
  try {
    stmt.execute("drop table TEST_QUERY_DB_TABLE");
    stmt.execute("drop table TEST_QUERY_DB_TABLE_2");
  }
 catch (  final SQLException sqle) {
  }
  stmt.execute("create table TEST_QUERY_DB_TABLE (id integer not null, bucket integer not null)");
  stmt.execute("insert into TEST_QUERY_DB_TABLE (id, bucket) VALUES (1, 0)");
  stmt.execute("create table TEST_QUERY_DB_TABLE_2 (id integer not null, bucket integer not null)");
  stmt.execute("insert into TEST_QUERY_DB_TABLE_2 (id, bucket) VALUES (1, 0)");
  runner.setProperty(GenerateTableFetch.TABLE_NAME,"${tableName}");
  runner.setIncomingConnection(true);
  runner.setProperty(GenerateTableFetch.MAX_VALUE_COLUMN_NAMES,"${maxValueCol}");
  runner.enqueue("".getBytes(),new HashMap<String,String>(){
{
      put("tableName","TEST_QUERY_DB_TABLE");
      put("maxValueCol","id");
    }
  }
);
  runner.enqueue("".getBytes(),new HashMap<String,String>(){
{
      put("tableName","TEST_QUERY_DB_TABLE_2");
      put("maxValueCol","id");
    }
  }
);
  runner.run(2);
  runner.assertAllFlowFilesTransferred(REL_SUCCESS,2);
  assertEquals(2,processor.columnTypeMap.size());
  runner.clearTransferState();
  Map.Entry<String,Integer> entry=processor.columnTypeMap.entrySet().iterator().next();
  String key=entry.getKey();
  processor.columnTypeMap.remove(key);
  stmt.execute("insert into TEST_QUERY_DB_TABLE (id, bucket) VALUES (2, 0)");
  runner.enqueue("".getBytes(),new HashMap<String,String>(){
{
      put("tableName","TEST_QUERY_DB_TABLE");
      put("maxValueCol","id");
    }
  }
);
  runner.run();
  runner.assertAllFlowFilesTransferred(REL_SUCCESS,1);
  assertEquals(2,processor.columnTypeMap.size());
  runner.clearTransferState();
}
