@Test public void testResumeWritesFixedLength() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
}