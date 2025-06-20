@Test public void testLargeRequest() throws IOException {
message=null;//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue(messageBuilder.toString().equals(HttpClientUtils.readResponse(result)));
}