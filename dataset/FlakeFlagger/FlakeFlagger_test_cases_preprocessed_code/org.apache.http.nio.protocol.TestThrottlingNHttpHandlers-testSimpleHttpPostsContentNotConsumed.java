/** 
 * This test case tests if the protocol handler can correctly deal with requests with partially consumed content.
 */
@Test public void testSimpleHttpPostsContentNotConsumed() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,testjob.getStatusCode());
Assert.assertEquals("Ooopsie",testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}