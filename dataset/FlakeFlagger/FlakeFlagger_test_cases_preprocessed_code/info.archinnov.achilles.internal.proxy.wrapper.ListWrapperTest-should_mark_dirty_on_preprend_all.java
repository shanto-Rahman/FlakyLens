@Test public void should_mark_dirty_on_preprend_all() throws Exception {
assertThat(target).containsExactly("b","c");
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(PREPEND_TO_LIST);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawListChanges()).containsExactly("b","c");
}