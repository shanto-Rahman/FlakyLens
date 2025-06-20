@Test public void should_parse_primary_key() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("id");
assertThat(meta.<Long>getValueClass()).isEqualTo(Long.class);
assertThat(context.getPropertyMetas()).hasSize(1);
}