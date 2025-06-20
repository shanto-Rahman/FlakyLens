/** 
 * This test case executes a series of simple GET requests
 */
@Test public void testSimpleBasicHttpRequests() throws Exception {
if (s.startsWith("/?")) {
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