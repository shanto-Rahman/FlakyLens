@Test public void should_build_set() throws Exception {
assertThat(built.type()).isEqualTo(SET);
assertThat(built.getPropertyName()).isEqualTo("prop");
assertThat(built.<String>getValueClass()).isEqualTo(String.class);
assertThat(built.isEmbeddedId()).isFalse();
assertThat(built.getTranscoder()).isInstanceOf(SetTranscoder.class);
}