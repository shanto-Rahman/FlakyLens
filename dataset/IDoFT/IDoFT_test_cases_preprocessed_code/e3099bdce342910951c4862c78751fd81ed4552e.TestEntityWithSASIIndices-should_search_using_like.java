@Test public void should_search_using_like() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual.get(0).getContainsStandardAnalyzer()).isEqualTo("the chair is dancing");
}