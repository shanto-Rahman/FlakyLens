@Test public void should_dirty_check_map_put_element() throws Exception {
assertThat(preferences).hasSize(4);
assertThat(preferences.get(4)).isEqualTo("test");
}