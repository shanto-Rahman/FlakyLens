/** 
 * This test case executes a series of simple (non-pipelined) POST requests over multiple connections that do not meet the target server expectations.
 */
@Test public void testHttpPostsWithExpectationVerification() throws Exception {
if (!s.equals("AAAAAx10")) {
}
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(testjob.getExpected(),testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
Assert.assertEquals(HttpStatus.SC_EXPECTATION_FAILED,failedExpectation.getStatusCode());
}