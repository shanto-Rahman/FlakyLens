/** 
 * This test case executes a series of simple (non-pipelined) POST requests with no entities on the client side, to ensure they are sent properly, and the server can read them.
 */
@Test public void testHttpPostWithNoEntities() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_OK,testjob.getStatusCode());
Assert.assertEquals("",testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}