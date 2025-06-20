@Test public void testMaxRequestEntitySize() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(500,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}