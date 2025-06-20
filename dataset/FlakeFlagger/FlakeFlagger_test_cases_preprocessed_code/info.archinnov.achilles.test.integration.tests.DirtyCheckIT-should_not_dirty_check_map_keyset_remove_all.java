@Test public void should_not_dirty_check_map_keyset_remove_all() throws Exception {
assertThat(preferences).hasSize(3);
assertThat(preferences.get(1)).isEqualTo("FR");
assertThat(preferences.get(2)).isEqualTo("Paris");
assertThat(preferences.get(3)).isEqualTo("75014");
}