@Test public void should_dirty_check_list_element_set() throws Exception {
assertThat(friends).hasSize(2);
assertThat(friends.get(1)).isEqualTo("qux");
}