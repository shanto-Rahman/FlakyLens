@Test public void should_not_mark_dirty_on_remove_from_keySet_iterator() throws Exception {
assertThat(dirtyMap).isEmpty();
}