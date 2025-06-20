@Test public void should_mark_dirty_on_element_prepend() throws Exception {
assertThat(target).hasSize(1);
assertThat(target.get(0)).isEqualTo("a");
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(PREPEND_TO_LIST);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawListChanges()).containsOnly("a");
}