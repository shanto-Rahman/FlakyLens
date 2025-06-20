@Test public void testSmallRequest() throws IOException {
message=null;//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue("a".equals(HttpClientUtils.readResponse(result)));
}