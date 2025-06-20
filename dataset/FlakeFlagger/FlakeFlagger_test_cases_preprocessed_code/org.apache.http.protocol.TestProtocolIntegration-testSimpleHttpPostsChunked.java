/** 
 * This test case executes a series of simple POST requests with chunk coded content content.
 */
@Test public void testSimpleHttpPostsChunked() throws Exception {
if (request instanceof HttpEntityEnclosingRequest) {
}
if (!conn.isOpen()) {
}
Assert.assertEquals(expected.length,received.length);
Assert.assertEquals(expected[i],received[i]);
if (!this.client.keepAlive(response)) {
}
Assert.assertEquals(reqNo,cm.getRequestCount());
Assert.assertEquals(reqNo,cm.getResponseCount());
}