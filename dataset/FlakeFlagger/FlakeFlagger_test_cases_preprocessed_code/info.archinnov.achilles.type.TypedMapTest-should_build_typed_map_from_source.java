@Test public void should_build_typed_map_from_source() throws Exception {
assertThat(typedMap.<String>getTyped("string")).isInstanceOf(String.class);
assertThat(typedMap.<Integer>getTyped("int")).isInstanceOf(Integer.class);
}