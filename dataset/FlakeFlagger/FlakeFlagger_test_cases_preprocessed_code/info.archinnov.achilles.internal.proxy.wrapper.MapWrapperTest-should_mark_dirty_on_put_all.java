@Test public void should_mark_dirty_on_put_all() throws Exception {
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(ADD_TO_MAP);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawMapChanges()).hasSize(2).contains(entry(1,"FR"),entry(2,"Paris"));
}