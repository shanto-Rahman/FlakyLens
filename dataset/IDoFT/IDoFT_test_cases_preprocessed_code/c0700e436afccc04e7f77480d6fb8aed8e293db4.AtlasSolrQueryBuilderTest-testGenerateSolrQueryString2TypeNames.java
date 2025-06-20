@Test public void testGenerateSolrQueryString2TypeNames() throws IOException, AtlasBaseException {
Assert.assertEquals(underTest.build(),"+t  AND  -__state_index:DELETED AND  +__typeName__index:(hive_table hive_db ) ");
}