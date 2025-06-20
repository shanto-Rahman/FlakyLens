@Test public void should_search_using_end_with() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual.get(0).getContainsStandardAnalyzer()).isEqualTo("the loving man");
}