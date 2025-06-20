public void testGetTableMetaData(){
assertEquals(tableMetaData.getColumnNames().size(),tableMetaData.getColumnTypes().size());
assertEquals(20,tableMetaData.getColumnNames().size());
assertTrue(assigneeIndex >= 0);
assertTrue(createTimeIndex >= 0);
}