@Test public void should_mark_dirty_on_element_add() throws Exception {
assertThat(target).containsExactly("a");
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(APPEND_TO_LIST);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawListChanges()).containsExactly("a");
}