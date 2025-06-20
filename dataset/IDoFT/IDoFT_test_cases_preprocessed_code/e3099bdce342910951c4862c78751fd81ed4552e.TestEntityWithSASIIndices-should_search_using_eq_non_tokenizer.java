@Test public void should_search_using_eq_non_tokenizer() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual.get(0).getPrefixNonTokenizer()).isEqualTo("speedster");
}