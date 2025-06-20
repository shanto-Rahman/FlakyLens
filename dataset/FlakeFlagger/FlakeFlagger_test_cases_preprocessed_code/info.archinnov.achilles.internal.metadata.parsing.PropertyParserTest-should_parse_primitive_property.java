@Test public void should_parse_primitive_property() throws Exception {
assertThat(meta.<Boolean>getValueClass()).isEqualTo(boolean.class);
}