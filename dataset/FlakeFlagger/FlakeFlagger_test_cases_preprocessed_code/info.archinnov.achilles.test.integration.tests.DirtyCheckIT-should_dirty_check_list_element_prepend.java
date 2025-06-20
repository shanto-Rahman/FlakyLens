@Test public void should_dirty_check_list_element_prepend() throws Exception {
assertThat(friends).hasSize(5);
assertThat(friends.get(0)).isEqualTo("three");
assertThat(friends.get(1)).isEqualTo("two");
assertThat(friends.get(2)).isEqualTo("one");
}