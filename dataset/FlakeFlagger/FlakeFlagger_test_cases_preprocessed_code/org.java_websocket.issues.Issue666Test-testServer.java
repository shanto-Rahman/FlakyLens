@Test public void testServer() throws Exception {
countServerDownLatch.countDown();
countServerDownLatch.await();
String name=thread.getName();
if (!name.startsWith("WebSocketSelector-") && !name.startsWith("WebSocketWorker-") && !name.equals("WebSocketTimer")) {
Assert.fail("Thread not correctly named! Is: " + name);
}
}