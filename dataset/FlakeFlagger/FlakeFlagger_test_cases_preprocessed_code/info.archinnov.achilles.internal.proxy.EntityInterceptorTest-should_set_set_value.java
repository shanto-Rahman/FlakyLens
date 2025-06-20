@Test public void should_set_set_value() throws Throwable {
assertThat(actual).isNull();
assertThat(alreadyLoaded).isEmpty();
assertThat(dirtyMap).containsKey(method);
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(pm);
assertThat(changeSets).hasSize(1);
assertThat(changeSet.getChangeType()).isEqualTo(ASSIGN_VALUE_TO_SET);
assertThat(changeSet.getRawSetChanges()).isSameAs(set);
}