@Test public void should_not_dirty_check_list_element_list_iterator_set() throws Exception {
assertThat(friends).hasSize(2);
assertThat(friends).contains("foo","bar");
}