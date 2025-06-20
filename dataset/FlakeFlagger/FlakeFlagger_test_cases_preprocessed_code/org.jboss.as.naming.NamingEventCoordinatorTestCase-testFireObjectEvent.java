@Test public void testFireObjectEvent() throws Exception {
objectListener.latch.await(1,TimeUnit.SECONDS);
assertEquals(1,objectListener.capturedEvents.size());
assertTrue(oneLevelListener.capturedEvents.isEmpty());
assertTrue(subtreeListener.capturedEvents.isEmpty());
}