@Test public void testAddedRowsTwoTables() throws ClassNotFoundException, SQLException, InitializationException, IOException {
assertEquals("TEST_QUERY_DB_TABLE",flowFile.getAttribute(QueryDatabaseTable.RESULT_TABLENAME));
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals(2,getNumberOfRecordsFromStream(in));
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals(1,getNumberOfRecordsFromStream(in));
assertEquals("TEST_QUERY_DB_TABLE2",flowFile.getAttribute(QueryDatabaseTable.RESULT_TABLENAME));
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals(3,getNumberOfRecordsFromStream(in));
assertEquals(flowFile.getAttribute("maxvalue.id"),"3");
assertEquals(1,getNumberOfRecordsFromStream(in));
}