@Test public void testRemoteAddress() throws IOException, InterruptedException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
latch.await(10,TimeUnit.SECONDS);
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header test-value",message);//RW
}