@Test public void should_set_list_value_to_null() throws Throwable {
assertThat(actual).isNull();
assertThat(alreadyLoaded).isEmpty();
assertThat(dirtyMap).containsKey(method);
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(pm);
assertThat(changeSets).hasSize(1);
assertThat(changeSet.getChangeType()).isEqualTo(REMOVE_COLLECTION_OR_MAP);
assertThat(changeSet.getRawListChanges()).isEmpty();
}