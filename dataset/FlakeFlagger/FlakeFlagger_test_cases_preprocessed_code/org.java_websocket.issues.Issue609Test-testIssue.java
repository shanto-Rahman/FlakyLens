@Test public void testIssue() throws Exception {
countDownLatch.countDown();
countServerDownLatch.countDown();
countServerDownLatch.await();
assertTrue("webSocket.isOpen()",webSocket.isOpen());
countDownLatch.await();
assertTrue("!webSocket.isOpen()",!webSocket.isOpen());
assertTrue("!wasOpenClient",!wasOpenClient);
assertTrue("!wasOpenServer",!wasOpenServer);
}