@Test public void should_mark_dirty_on_retain_all() throws Exception {
assertThat(target).containsOnly("a","c");
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(REMOVE_FROM_SET);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawSetChanges()).containsOnly("b");
}