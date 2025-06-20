@Test public void testHttpContinueRejected() throws IOException {
accept=false;//RW
Assert.assertEquals(417,result.getStatusLine().getStatusCode());
}