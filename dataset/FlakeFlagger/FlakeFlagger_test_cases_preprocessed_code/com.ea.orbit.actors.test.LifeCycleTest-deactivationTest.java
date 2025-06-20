@Test public void deactivationTest() throws ExecutionException, InterruptedException {
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(60));
assertEquals(machEventCount,player.getMatchEventCount().get().intValue());
}