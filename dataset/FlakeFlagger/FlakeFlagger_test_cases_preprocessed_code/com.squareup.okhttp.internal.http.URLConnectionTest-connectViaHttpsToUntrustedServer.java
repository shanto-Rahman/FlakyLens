/** 
 * Verify that we don't retry connections on certificate verification errors. http://code.google.com/p/android/issues/detail?id=13178
 */
@Test public void connectViaHttpsToUntrustedServer() throws IOException, InterruptedException {
fail();
assertTrue(expected.getCause() instanceof CertificateException);
assertEquals(0,server.getRequestCount());
}