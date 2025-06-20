@Test public void should_build_simple() throws Exception {
assertThat(built.type()).isEqualTo(SIMPLE);
assertThat(built.getPropertyName()).isEqualTo("prop");
assertThat(built.<String>getValueClass()).isEqualTo(String.class);
assertThat(built.getField()).isEqualTo(field);
assertThat(built.isEmbeddedId()).isFalse();
assertThat(built.getReadConsistencyLevel()).isEqualTo(ONE);
assertThat(built.getWriteConsistencyLevel()).isEqualTo(ALL);
assertThat(built.getTranscoder()).isInstanceOf(SimpleTranscoder.class);
}