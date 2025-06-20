@Test public void should_search_using_prefix_non_tokenizer() throws Exception {
assertThat(actual).hasSize(2);
assertThat(actual.get(0).getPrefixNonTokenizer()).isEqualTo("speed runner");
assertThat(actual.get(1).getPrefixNonTokenizer()).isEqualTo("speedster");
}