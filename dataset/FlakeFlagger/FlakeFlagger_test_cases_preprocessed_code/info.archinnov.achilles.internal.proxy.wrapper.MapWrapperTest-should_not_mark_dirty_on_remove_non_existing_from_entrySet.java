@Test public void should_not_mark_dirty_on_remove_non_existing_from_entrySet() throws Exception {
assertThat(dirtyMap).isEmpty();
}