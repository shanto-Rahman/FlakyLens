@Test public void sendHttpRequest() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
}