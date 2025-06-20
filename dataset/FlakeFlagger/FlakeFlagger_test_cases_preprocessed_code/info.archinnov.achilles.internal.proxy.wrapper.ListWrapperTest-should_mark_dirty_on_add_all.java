@Test public void should_mark_dirty_on_add_all() throws Exception {
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(APPEND_TO_LIST);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawListChanges()).containsOnly("a","b");
}