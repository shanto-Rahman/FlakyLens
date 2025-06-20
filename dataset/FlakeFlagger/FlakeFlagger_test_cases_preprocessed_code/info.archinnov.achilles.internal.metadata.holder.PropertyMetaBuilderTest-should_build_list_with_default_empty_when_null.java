@Test public void should_build_list_with_default_empty_when_null() throws Exception {
assertThat(built.type()).isEqualTo(LIST);
assertThat(built.getPropertyName()).isEqualTo("prop");
assertThat(built.<String>getValueClass()).isEqualTo(String.class);
assertThat(built.isEmbeddedId()).isFalse();
assertThat(built.nullValueForCollectionAndMap()).isNotNull().isInstanceOf(List.class);
assertThat(built.getTranscoder()).isInstanceOf(ListTranscoder.class);
}