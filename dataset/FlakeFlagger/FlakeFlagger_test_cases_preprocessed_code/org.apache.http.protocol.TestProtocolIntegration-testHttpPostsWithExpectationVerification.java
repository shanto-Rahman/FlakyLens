/** 
 * This test case executes a series of simple POST requests that do not meet the target server expectations.
 */
@Test public void testHttpPostsWithExpectationVerification() throws Exception {
if (someheader != null) {
if (secretNumber < 2) {
}
}
if (!conn.isOpen()) {
}
Assert.assertNotNull(entity);
if (r < 2) {
Assert.assertEquals(HttpStatus.SC_EXPECTATION_FAILED,response.getStatusLine().getStatusCode());
Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
}
if (!this.client.keepAlive(response)) {
}
Assert.assertEquals(reqNo,cm.getRequestCount());
Assert.assertEquals(reqNo,cm.getResponseCount());
}