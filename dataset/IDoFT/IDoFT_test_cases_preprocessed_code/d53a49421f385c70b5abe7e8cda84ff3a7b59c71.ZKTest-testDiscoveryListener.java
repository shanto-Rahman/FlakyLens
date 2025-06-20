@Test public void testDiscoveryListener() throws Exception {
joinLatch.countDown();
leaveLatch.countDown();
joinLatch.await();
leaveLatch.await();
}