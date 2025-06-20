@Test public void should_dirty_check_list_element_remove_element_only_once() throws Exception {
assertThat(friends).hasSize(4);
assertThat(friends.get(0)).isEqualTo("qux");
assertThat(friends.get(1)).isEqualTo("tux");
assertThat(friends.get(2)).isEqualTo("foo");
assertThat(friends.get(3)).isEqualTo("bar");
}