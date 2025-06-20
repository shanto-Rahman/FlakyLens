@Test public void shouldUseTaskExecutorWhenRunningInParallel() throws Exception {
invoked.set(true);
assertFalse(invoked.get());
assertTrue(invoked.get());
}