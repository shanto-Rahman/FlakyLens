@Test public void testResumeOnSocketTimeoutInChunk() throws IOException {
if (i > 0) {
}
Assert.assertEquals(20,bytesRead);
Assert.assertEquals(5,timeouts);
}