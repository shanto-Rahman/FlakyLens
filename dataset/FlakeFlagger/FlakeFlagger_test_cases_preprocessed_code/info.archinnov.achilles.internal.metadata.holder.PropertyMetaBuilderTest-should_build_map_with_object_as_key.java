@Test public void should_build_map_with_object_as_key() throws Exception {
assertThat(built.type()).isEqualTo(MAP);
assertThat(built.getPropertyName()).isEqualTo("prop");
assertThat(built.<Bean>getKeyClass()).isEqualTo(Bean.class);
assertThat(built.<String>getValueClass()).isEqualTo(String.class);
assertThat(built.getTranscoder()).isInstanceOf(MapTranscoder.class);
}