@Test public void sendHttpRequest() throws IOException {
message="My HTTP Request!";//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
}