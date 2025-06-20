@SuppressWarnings("unchecked") @Test public void excludedDeltas() throws Exception {
assertFalse(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"excludes")).contains("**/*.jar"));
}