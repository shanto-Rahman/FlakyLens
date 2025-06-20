@Test public void should_dirty_check_list_element_add() throws Exception {
assertThat(friends).hasSize(5);
assertThat(friends.get(2)).isEqualTo("qux");
assertThat(friends.get(3)).isEqualTo("qux");
assertThat(friends.get(4)).isEqualTo("qux");
}