@Test public void testFireSubTreeEvent() throws Exception {
subtreeListener.latch.await(1,TimeUnit.SECONDS);
assertTrue(objectListener.capturedEvents.isEmpty());
assertTrue(oneLevelListener.capturedEvents.isEmpty());
assertEquals(1,subtreeListener.capturedEvents.size());
}