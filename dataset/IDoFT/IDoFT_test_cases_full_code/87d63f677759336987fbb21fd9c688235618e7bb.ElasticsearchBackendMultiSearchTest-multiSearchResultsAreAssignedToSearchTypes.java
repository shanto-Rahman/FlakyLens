@Test public void multiSearchResultsAreAssignedToSearchTypes() throws Exception {
  final ESGeneratedQueryContext queryContext=this.elasticsearchBackend.generate(searchJob,query,Collections.emptySet());
  when(jestClient.execute(any(),any())).thenReturn(resultFor(resourceFile("successfulMultiSearchResponse.json")));
  final QueryResult queryResult=this.elasticsearchBackend.doRun(searchJob,query,queryContext,Collections.emptySet());
  assertThat(queryResult.searchTypes()).containsOnlyKeys("pivot1","pivot2");
  final PivotResult pivot1Result=(PivotResult)queryResult.searchTypes().get("pivot1");
  assertThat(pivot1Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("avg(field1)"),27220.273504273504,true,"row-leaf")).build());
  final PivotResult pivot2Result=(PivotResult)queryResult.searchTypes().get("pivot2");
  assertThat(pivot2Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("max(field2)"),42.0,true,"row-leaf")).build());
}
