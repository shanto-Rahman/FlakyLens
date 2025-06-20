@Test public void should_build_compound_id() throws Exception {
assertThat(built.type()).isEqualTo(EMBEDDED_ID);
assertThat(built.getPropertyName()).isEqualTo("prop");
assertThat(built.<EmbeddedKey>getValueClass()).isEqualTo(EmbeddedKey.class);
assertThat(built.isEmbeddedId()).isTrue();
assertThat(built.getReadConsistencyLevel()).isEqualTo(ONE);
assertThat(built.getWriteConsistencyLevel()).isEqualTo(ALL);
assertThat(built.getTranscoder()).isInstanceOf(CompoundTranscoder.class);
}