@Test public void testHttpContinueAccepted() throws IOException {
accept=true;//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));
}