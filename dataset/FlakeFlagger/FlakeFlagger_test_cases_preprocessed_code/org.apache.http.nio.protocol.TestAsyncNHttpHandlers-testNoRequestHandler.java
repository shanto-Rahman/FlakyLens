@Test public void testNoRequestHandler() throws Exception {
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_NOT_IMPLEMENTED,testjob.getStatusCode());
Assert.fail(testjob.getFailureMessage());
}
}