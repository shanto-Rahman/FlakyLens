@Test public void shouldUseTaskExecutorWhenRunningInParallel() throws Exception {
assertFalse(invoked.get());
assertTrue(invoked.get());
}