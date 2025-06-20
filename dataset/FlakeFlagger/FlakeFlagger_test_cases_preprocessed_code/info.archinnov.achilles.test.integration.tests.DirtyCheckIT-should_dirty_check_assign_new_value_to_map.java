@Test public void should_dirty_check_assign_new_value_to_map() throws Exception {
assertThat(preferences).hasSize(2);
assertThat(preferences).containsKey(4);
assertThat(preferences.get(4)).isEqualTo("test");
assertThat(preferences).containsKey(5);
assertThat(preferences.get(5)).isEqualTo("again");
}