@Test public void multiSearchResultsAreAssignedToSearchTypes() throws Exception {
assertThat(queryResult.searchTypes()).containsOnlyKeys("pivot1","pivot2");
assertThat(pivot1Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("avg(field1)"),27220.273504273504,true,"row-leaf")).build());
assertThat(pivot2Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("max(field2)"),42.0,true,"row-leaf")).build());
}