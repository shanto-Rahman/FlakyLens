/** 
 * This test case executes a series of simple HTTP/1.0 POST requests.
 */
@Test public void testSimpleHttpPostsHTTP10() throws Exception {
if (request instanceof HttpEntityEnclosingRequest) {
}
if (!conn.isOpen()) {
}
Assert.assertEquals(HttpVersion.HTTP_1_0,response.getStatusLine().getProtocolVersion());
Assert.assertEquals(expected.length,received.length);
Assert.assertEquals(expected[i],received[i]);
if (!this.client.keepAlive(response)) {
}
Assert.assertEquals(reqNo,cm.getRequestCount());
Assert.assertEquals(reqNo,cm.getResponseCount());
}