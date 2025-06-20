@Test public void testIssue() throws Exception {
countDownLatch0.countDown();
countServerDownLatch.countDown();
countServerDownLatch.await();
assertTrue("webSocket.isOpen()",webSocket0.isOpen());
assertTrue("webSocket.isClosing()",webSocket0.isClosing());
countDownLatch0.await();
assertTrue("webSocket.isClosed()",webSocket0.isClosed());
assertTrue("webSocket.isOpen()",webSocket1.isOpen());
assertTrue("webSocket.isClosed()",webSocket1.isClosed());
}