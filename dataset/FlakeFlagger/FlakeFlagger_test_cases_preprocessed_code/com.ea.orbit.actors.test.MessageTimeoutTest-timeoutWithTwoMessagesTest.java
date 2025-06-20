@Test public void timeoutWithTwoMessagesTest() throws ExecutionException, InterruptedException {
assertEquals(uuid,someActor.getUniqueActivationId().get());
Future<UUID> first=someActor.getUniqueActivationId(TimeUnit.SECONDS.toNanos(200));
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(60));
Future<UUID> second=someActor.getUniqueActivationId(TimeUnit.SECONDS.toNanos(200));
assertFalse(first.isDone());
assertFalse(second.isDone());
assertTrue(first.isDone());
assertFalse(second.isDone());
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(60));
assertFalse(second.isDone());
assertTrue(second.isDone());
}