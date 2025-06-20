@Test public void testTruncatedChunkException() throws Exception {
testjob.fail(ex.getMessage(),ex);
Assert.assertFalse(testjob.isSuccessful());
Assert.assertNotNull(testjob.getException());
Assert.assertTrue(testjob.getException() instanceof MalformedChunkCodingException);
}