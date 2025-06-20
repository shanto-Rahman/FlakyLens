@Test public void testFireOneLevelEvent() throws Exception {
oneLevelListener.latch.await(1,TimeUnit.SECONDS);
assertTrue(objectListener.capturedEvents.isEmpty());
assertTrue(subtreeListener.capturedEvents.isEmpty());
assertEquals(1,oneLevelListener.capturedEvents.size());
}