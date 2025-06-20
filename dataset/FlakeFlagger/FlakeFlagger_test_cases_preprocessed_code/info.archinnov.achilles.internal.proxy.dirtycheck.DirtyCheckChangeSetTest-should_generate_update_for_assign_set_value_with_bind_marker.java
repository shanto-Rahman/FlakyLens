@Test public void should_generate_update_for_assign_set_value_with_bind_marker() throws Exception {
assertThat(vals[0]).isNull();
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property=:property;");
}