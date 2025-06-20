@Test public void should_dirty_check_assign_new_value_to_list() throws Exception {
assertThat(friends).containsOnly("qux","tux");
}