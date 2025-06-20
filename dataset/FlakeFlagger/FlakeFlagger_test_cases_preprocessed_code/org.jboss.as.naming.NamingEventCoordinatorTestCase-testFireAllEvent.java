@Test public void testFireAllEvent() throws Exception {
objectListener.latch.await(1,TimeUnit.SECONDS);
oneLevelListener.latch.await(1,TimeUnit.SECONDS);
subtreeListener.latch.await(1,TimeUnit.SECONDS);
assertEquals(1,objectListener.capturedEvents.size());
assertEquals(1,subtreeListener.capturedEvents.size());
assertEquals(1,oneLevelListener.capturedEvents.size());
}