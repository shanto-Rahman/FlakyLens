@Test public void should_generate_update_for_prepended_element_with_bind_marker() throws Exception {
assertThat(vals[0]).isNull();
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property=:property+property;");
}