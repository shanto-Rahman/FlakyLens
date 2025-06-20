@Test public void should_generate_remove_element_at_index_to_list_update() throws Exception {
assertThat(pair.left.getQueryString()).isEqualTo("UPDATE table WHERE id=" + id + ";");
assertThat(pair.right[0]).isEqualTo("whatever");
}