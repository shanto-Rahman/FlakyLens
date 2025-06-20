/** 
 * Test that MockWebServer blocks for a call to enqueue() if a request is made before a mock response is ready.
 */
public void testDispatchBlocksWaitingForEnqueue() throws Exception {
new Thread(){
  @Override public void run(){
    try {
      Thread.sleep(1000);
    }
 catch (    InterruptedException ignored) {
    }
    server.enqueue(new MockResponse().setBody("enqueued in the background"));
  }
}
.start();
Thread.sleep(1000);
assertEquals("enqueued in the background",reader.readLine());
}