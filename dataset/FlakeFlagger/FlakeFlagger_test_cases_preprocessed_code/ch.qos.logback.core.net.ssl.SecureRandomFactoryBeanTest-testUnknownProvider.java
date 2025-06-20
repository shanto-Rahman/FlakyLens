@Test public void testUnknownProvider() throws Exception {
fail("expected NoSuchProviderException");
assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_PROVIDER_NAME));
}