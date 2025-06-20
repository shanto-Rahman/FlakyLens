@Test public void testSenderSetsContentLength() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(HELLO_WORLD,HttpClientUtils.readResponse(result));
Assert.assertEquals(1,header.length);
Assert.assertEquals("" + HELLO_WORLD.length(),header[0].getValue());
}