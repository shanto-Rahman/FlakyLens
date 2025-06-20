/** 
 * This test case executes a series of simple (non-pipelined) HEAD requests over multiple connections. This test uses nonblocking entities.
 */
@Test public void testHttpHeads() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.getFailureMessage() != null) {
Assert.fail(testjob.getFailureMessage());
}
Assert.assertEquals(HttpStatus.SC_OK,testjob.getStatusCode());
Assert.assertNull(testjob.getResult());
}