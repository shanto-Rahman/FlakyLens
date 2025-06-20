@Test public void sendHttpHead() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("",HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("",HttpClientUtils.readResponse(result));
}