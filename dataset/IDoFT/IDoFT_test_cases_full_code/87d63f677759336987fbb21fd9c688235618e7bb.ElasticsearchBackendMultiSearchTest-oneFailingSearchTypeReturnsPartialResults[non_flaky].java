@Test public void oneFailingSearchTypeReturnsPartialResults() throws Exception {
  final ESGeneratedQueryContext queryContext=this.elasticsearchBackend.generate(searchJob,query,Collections.emptySet());
  when(jestClient.execute(any(),any())).thenReturn(resultFor(resourceFile("partiallySuccessfulMultiSearchResponse.json")));
  final QueryResult queryResult=this.elasticsearchBackend.doRun(searchJob,query,queryContext,Collections.emptySet());
  assertThat(queryResult.errors()).hasSize(1);
  final SearchTypeError searchTypeError=(SearchTypeError)new ArrayList<>(queryResult.errors()).get(0);
  assertThat(searchTypeError.description()).isEqualTo("Unable to perform search query: \n" + "\n" + "Expected numeric type on field [field1], but got [keyword].");
  assertThat(searchTypeError.searchTypeId()).isEqualTo("pivot1");
  assertThat(queryResult.searchTypes()).containsOnlyKeys("pivot2");
  final PivotResult pivot2Result=(PivotResult)queryResult.searchTypes().get("pivot2");
  assertThat(pivot2Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("max(field2)"),42.0,true,"row-leaf")).build());
}
