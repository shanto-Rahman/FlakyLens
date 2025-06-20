@Test public void should_parse_enum_property() throws Exception {
assertThat(meta.<PropertyType>getValueClass()).isEqualTo(PropertyType.class);
}