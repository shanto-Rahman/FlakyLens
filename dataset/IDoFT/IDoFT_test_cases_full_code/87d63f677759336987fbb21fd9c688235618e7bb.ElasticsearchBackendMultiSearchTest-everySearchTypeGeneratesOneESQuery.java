@Test public void everySearchTypeGeneratesOneESQuery() throws Exception {
  final ESGeneratedQueryContext queryContext=this.elasticsearchBackend.generate(searchJob,query,Collections.emptySet());
  when(jestClient.execute(any(),any())).thenReturn(resultFor(resourceFile("successfulMultiSearchResponse.json")));
  final String generatedRequest=run(searchJob,query,queryContext,Collections.emptySet());
  assertThat(generatedRequest).isEqualTo(resourceFile("everySearchTypeGeneratesOneESQuery.request.ndjson"));
}
