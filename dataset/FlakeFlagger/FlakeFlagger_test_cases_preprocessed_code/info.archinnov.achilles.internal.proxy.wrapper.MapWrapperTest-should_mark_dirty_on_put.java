@Test public void should_mark_dirty_on_put() throws Exception {
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getChangeType()).isEqualTo(ADD_TO_MAP);
assertThat(changeSet.getPropertyMeta()).isEqualTo(propertyMeta);
assertThat(changeSet.getRawMapChanges()).hasSize(1).containsKey(4).containsValue("sdfs");
}