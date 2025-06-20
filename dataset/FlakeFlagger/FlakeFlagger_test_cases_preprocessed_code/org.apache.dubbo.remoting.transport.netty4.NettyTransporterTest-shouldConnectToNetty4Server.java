@Test public void shouldConnectToNetty4Server() throws Exception {
lock.countDown();
lock.await();
}