@Test public void testClient() throws Exception {
countServerDownLatch.countDown();
countServerDownLatch.await();
String name=thread.getName();
if (!name.equals("WebSocketTimer") && !name.startsWith("WebSocketWriteThread-") && !name.startsWith("WebSocketConnectReadThread-")) {
Assert.fail("Thread not correctly named! Is: " + name);
}
}