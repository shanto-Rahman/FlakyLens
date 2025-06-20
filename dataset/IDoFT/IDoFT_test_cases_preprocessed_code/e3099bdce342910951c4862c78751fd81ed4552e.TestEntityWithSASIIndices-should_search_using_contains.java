@Test public void should_search_using_contains() throws Exception {
assertThat(actual).hasSize(5);
assertThat(actual.get(0).getContainsStandardAnalyzer()).isEqualTo("forever love");
assertThat(actual.get(1).getContainsStandardAnalyzer()).isEqualTo("lovers");
assertThat(actual.get(2).getContainsStandardAnalyzer()).isEqualTo("the white gloves");
assertThat(actual.get(3).getContainsStandardAnalyzer()).isEqualTo("the loving man");
assertThat(actual.get(4).getContainsStandardAnalyzer()).isEqualTo("no love");
}