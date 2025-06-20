@Test public void timeoutTest() throws ExecutionException, InterruptedException {
assertEquals(uuid,someActor.getUniqueActivationId().get());
Future<UUID> call=someActor.getUniqueActivationId(TimeUnit.SECONDS.toNanos(200));
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(60));
assertTrue(call.isDone());
}