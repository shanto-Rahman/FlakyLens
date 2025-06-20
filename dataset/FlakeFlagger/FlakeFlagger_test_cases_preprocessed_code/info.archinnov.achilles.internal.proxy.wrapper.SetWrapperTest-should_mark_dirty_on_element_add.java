@Test public void should_mark_dirty_on_element_add() throws Exception {
assertThat(target).containsExactly("a");
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(ADD_TO_SET);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawSetChanges()).containsExactly("a");
}