@Test public void testAddedRowsTwoTables() throws SQLException {
assertEquals("TEST_QUERY_DB_TABLE",flowFile.getAttribute(QueryDatabaseTableRecord.RESULT_TABLENAME));
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals("TEST_QUERY_DB_TABLE2",flowFile.getAttribute(QueryDatabaseTableRecord.RESULT_TABLENAME));
assertEquals(flowFile.getAttribute("maxvalue.id"),"2");
assertEquals(flowFile.getAttribute("maxvalue.id"),"3");
}