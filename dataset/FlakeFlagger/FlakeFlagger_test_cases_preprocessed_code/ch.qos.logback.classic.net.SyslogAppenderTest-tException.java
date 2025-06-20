@Test public void tException() throws InterruptedException {
assertTrue(mockServer.isFinished());
assertEquals(21,mockServer.getMessageList().size());
assertTrue(msg.startsWith(expected));
String threadName=Thread.currentThread().getName();
assertTrue(msg.contains(ex.getClass().getName()));
assertTrue(msg.contains(ex.getMessage()));
assertTrue(msg.startsWith(expected));
}