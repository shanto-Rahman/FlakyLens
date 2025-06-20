@Test public void testInputThrottling() throws Exception {
if (queue == null) {
}
if (testjob != null) {
}
if (testjob == null) {
}
if (entity != null) {
Thread.sleep(1);
if (charset == null) {
}
}
if (testjob != null) {
testjob.fail("Request failed");
}
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_OK,testjob.getStatusCode());
Assert.assertEquals(testjob.getExpected(),testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}