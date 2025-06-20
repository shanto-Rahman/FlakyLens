@Test public void testAsyncSender() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(sb.toString(),HttpClientUtils.readResponse(result));
}