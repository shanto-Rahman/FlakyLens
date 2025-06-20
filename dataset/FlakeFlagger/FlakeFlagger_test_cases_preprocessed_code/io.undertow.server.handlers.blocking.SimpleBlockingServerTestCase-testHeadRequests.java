@Test public void testHeadRequests() throws IOException {
message="My HTTP Request!";//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("",HttpClientUtils.readResponse(result));
Assert.assertEquals(message.length() + "",result.getFirstHeader(Headers.CONTENT_LENGTH_STRING).getValue());//RW
}