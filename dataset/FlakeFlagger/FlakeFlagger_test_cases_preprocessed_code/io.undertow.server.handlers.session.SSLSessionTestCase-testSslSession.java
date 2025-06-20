@Test public void testSslSession() throws IOException {
if (session == null) {
}
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("0",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("1",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("2",header[0].getValue());
Assert.assertEquals(0,client.getCookieStore().getCookies().size());
}