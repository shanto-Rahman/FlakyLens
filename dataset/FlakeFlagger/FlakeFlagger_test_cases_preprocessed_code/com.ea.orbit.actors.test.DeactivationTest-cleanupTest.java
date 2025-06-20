@Test public void cleanupTest() throws ExecutionException, InterruptedException {
assertEquals(1,set.size());
assertEquals(1,set.size());
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(20));
assertEquals(2,set.size());
}