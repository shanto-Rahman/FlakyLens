@SuppressWarnings("unchecked") @Test public void includedDeltasAndNewEntries() throws Exception {
assertTrue(includes.contains("foo.jar"));
assertTrue(includes.contains("templates/**"));
assertFalse(includes.contains("static/**"));
assertFalse(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"excludes")).contains("**/*.jar"));
}