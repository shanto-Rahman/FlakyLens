@Test public void suffixPatternWithTag() throws InterruptedException {
assertTrue(mockServer.isFinished());
assertEquals(1,mockServer.getMessageList().size());
String threadName=Thread.currentThread().getName();
assertTrue(msg.startsWith(expected));
}