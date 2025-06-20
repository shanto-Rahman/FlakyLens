@Test public void should_parse_simple_property_and_override_name() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("firstname");
}