@Test public void testResumeOnSocketTimeoutInData() throws IOException {
if (i > 0) {
}
Assert.assertEquals(20,bytesRead);
Assert.assertEquals(2,timeouts);
}