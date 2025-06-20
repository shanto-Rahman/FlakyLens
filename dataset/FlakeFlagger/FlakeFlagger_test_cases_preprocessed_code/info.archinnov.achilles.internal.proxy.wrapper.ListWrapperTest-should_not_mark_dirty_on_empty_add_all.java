@Test public void should_not_mark_dirty_on_empty_add_all() throws Exception {
assertThat(target).hasSize(0);
assertThat(dirtyMap).isEmpty();
}