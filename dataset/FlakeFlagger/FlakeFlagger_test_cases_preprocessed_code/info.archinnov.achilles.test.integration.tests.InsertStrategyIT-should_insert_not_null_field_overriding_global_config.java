@Test public void should_insert_not_null_field_overriding_global_config() throws Exception {
assertThat(found.getName()).isEqualTo("Helen");
assertThat(found.getLabel()).isEqualTo("label");
}