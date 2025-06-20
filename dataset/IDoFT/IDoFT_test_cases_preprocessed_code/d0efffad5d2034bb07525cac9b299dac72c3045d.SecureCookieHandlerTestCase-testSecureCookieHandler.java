@Test public void testSecureCookieHandler() throws IOException, GeneralSecurityException {
Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
Assert.assertEquals("foo=bar; secure",header.getValue());
Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
Assert.assertEquals("foo=bar",header.getValue());
}