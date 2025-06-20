@Test public void testFireMultiLevelEvent() throws Exception {
subtreeListener.latch.await(1,TimeUnit.SECONDS);
subtreeListenerTwo.latch.await(1,TimeUnit.SECONDS);
subtreeListenerThree.latch.await(1,TimeUnit.SECONDS);
assertEquals(1,subtreeListener.capturedEvents.size());
assertEquals(1,subtreeListenerTwo.capturedEvents.size());
assertEquals(1,subtreeListenerThree.capturedEvents.size());
}