@Test public void simpleSSLTestCase() throws IOException, GeneralSecurityException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("https",header[0].getValue());
}