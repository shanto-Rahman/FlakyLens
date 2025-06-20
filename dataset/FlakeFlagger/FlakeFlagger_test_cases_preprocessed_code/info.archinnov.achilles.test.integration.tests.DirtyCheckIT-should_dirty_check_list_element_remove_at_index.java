@Test public void should_dirty_check_list_element_remove_at_index() throws Exception {
assertThat(friends).hasSize(2);
assertThat(friends.get(0)).isEqualTo("bar");
assertThat(friends.get(1)).isEqualTo("qux");
}