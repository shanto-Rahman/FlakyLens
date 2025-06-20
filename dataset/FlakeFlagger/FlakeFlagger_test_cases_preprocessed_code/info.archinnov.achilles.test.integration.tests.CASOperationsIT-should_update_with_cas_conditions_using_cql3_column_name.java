@Test public void should_update_with_cas_conditions_using_cql3_column_name() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("Helen");
}