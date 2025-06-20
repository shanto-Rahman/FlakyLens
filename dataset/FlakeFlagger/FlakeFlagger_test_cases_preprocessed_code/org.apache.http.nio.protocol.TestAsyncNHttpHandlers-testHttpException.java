/** 
 * This test ensures that HttpExceptions work correctly when immediate.
 */
@Test public void testHttpException() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,testjob.getStatusCode());
Assert.assertEquals(testjob.getPattern() + "x" + testjob.getCount(),testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}