@Test public void testGenerateSolrQueryString2TypeNames() throws IOException, AtlasBaseException {
  final String fileName="src/test/resources/searchparameters2Types.json";
  AtlasSolrQueryBuilder underTest=new AtlasSolrQueryBuilder();
  processSearchParametersForMultipleTypeNames(fileName,underTest);
  Assert.assertEquals(underTest.build(),"+t  AND  -__state_index:DELETED AND  +__typeName__index:(hive_table hive_db ) ");
}
