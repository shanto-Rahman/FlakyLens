@Test public void should_generate_update_for_set_element_at_index() throws Exception {
assertThat(vals[0]).isEqualTo(1);
assertThat(vals[1]).isEqualTo("a");
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property[1]=?;");
}