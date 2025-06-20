@Test public void should_dirty_check_map_put_all() throws Exception {
assertThat(preferences).hasSize(4);
assertThat(preferences.get(3)).isEqualTo("75015");
assertThat(preferences.get(4)).isEqualTo("test");
}