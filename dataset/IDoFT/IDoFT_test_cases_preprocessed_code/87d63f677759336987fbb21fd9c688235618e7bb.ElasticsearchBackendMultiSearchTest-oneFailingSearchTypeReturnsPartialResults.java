@Test public void oneFailingSearchTypeReturnsPartialResults() throws Exception {
assertThat(queryResult.errors()).hasSize(1);
assertThat(searchTypeError.description()).isEqualTo("Unable to perform search query\n" + "\n" + "Expected numeric type on field [field1], but got [keyword].");
assertThat(searchTypeError.searchTypeId()).isEqualTo("pivot1");
assertThat(queryResult.searchTypes()).containsOnlyKeys("pivot2");
assertThat(pivot2Result.rows().get(0)).isEqualTo(PivotResult.Row.builder().key(ImmutableList.of()).source("leaf").addValue(PivotResult.Value.create(Collections.singletonList("max(field2)"),42.0,true,"row-leaf")).build());
}