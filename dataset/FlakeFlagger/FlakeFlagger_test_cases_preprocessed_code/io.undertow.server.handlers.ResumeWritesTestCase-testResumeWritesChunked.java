@Test public void testResumeWritesChunked() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
}