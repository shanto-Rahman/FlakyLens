@Test public void testMaxRequestHeaderSize() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
if (DefaultServer.isProxy() || DefaultServer.isAjp()) {
Assert.assertEquals(500,response.getStatusLine().getStatusCode());
Assert.fail("request should have been too big");
}
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}