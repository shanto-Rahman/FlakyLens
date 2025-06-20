@SuppressWarnings("unchecked") @Test public void defaults() throws Exception {
assertTrue(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"includes")).contains("static/**"));
assertTrue(((Collection<String>)ReflectionTestUtils.getField(resourceMatcher,"excludes")).contains("**/*.jar"));
}