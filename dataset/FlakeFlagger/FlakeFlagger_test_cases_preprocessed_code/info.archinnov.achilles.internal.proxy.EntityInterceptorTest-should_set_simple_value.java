@Test public void should_set_simple_value() throws Throwable {
assertThat(actual).isNull();
assertThat(alreadyLoaded).isEmpty();
assertThat(dirtyMap).containsKey(method);
assertThat(dirtyChecker.getPropertyMeta()).isEqualTo(pm);
assertThat(dirtyChecker.isSimpleField()).isTrue();
}