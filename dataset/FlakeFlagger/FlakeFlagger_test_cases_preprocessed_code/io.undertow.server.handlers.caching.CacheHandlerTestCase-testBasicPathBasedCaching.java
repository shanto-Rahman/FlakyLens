@Test public void testBasicPathBasedCaching() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Response " + i,HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Response 5",HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Response 5",HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Response 5",HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Response 6",HttpClientUtils.readResponse(result));
}