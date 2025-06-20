@Test public void testIgnoreTruncatedChunkException() throws Exception {
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_OK,testjob.getStatusCode());
Assert.assertEquals(new String(GARBAGE,"US-ASCII"),testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}