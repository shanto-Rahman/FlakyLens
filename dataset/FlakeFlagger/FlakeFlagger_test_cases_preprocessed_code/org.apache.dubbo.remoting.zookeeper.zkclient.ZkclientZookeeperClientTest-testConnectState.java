@Test public void testConnectState() throws Exception {
assertThat(zkclientZookeeperClient.isConnected(),is(true));
stopLatch.countDown();
stopLatch.await();
assertThat(zkclientZookeeperClient.isConnected(),is(false));
}