@Test public void should_parse_allowed_type_property() throws Exception {
assertThat(meta.<UUID>getValueClass()).isEqualTo(UUID.class);
}