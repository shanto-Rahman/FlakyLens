@Test public void should_mark_dirty_on_remove_existing() throws Exception {
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(REMOVE_FROM_MAP);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawMapChanges()).hasSize(1).contains(entry(1,null));
}