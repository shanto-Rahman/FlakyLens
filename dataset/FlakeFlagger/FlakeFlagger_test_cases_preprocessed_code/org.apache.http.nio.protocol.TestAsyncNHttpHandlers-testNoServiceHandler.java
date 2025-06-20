/** 
 * This test makes sure that if no service handler is installed, things still work.
 */
@Test public void testNoServiceHandler() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_NOT_IMPLEMENTED,testjob.getStatusCode());
Assert.assertEquals("",testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}