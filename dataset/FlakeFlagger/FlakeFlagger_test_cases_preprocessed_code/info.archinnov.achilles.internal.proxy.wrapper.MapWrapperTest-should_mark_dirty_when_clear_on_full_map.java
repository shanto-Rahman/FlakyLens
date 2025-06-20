@Test public void should_mark_dirty_when_clear_on_full_map() throws Exception {
assertThat(target).isEmpty();
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(REMOVE_COLLECTION_OR_MAP);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawMapChanges()).isEmpty();
}