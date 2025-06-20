@Test public void should_generate_set_element_at_index_to_list_with_cas_conditions() throws Exception {
assertThat(pair.left.getQueryString()).isEqualTo("UPDATE table WHERE id=" + id + ";");
assertThat(pair.right[0]).isEqualTo("whatever");
}