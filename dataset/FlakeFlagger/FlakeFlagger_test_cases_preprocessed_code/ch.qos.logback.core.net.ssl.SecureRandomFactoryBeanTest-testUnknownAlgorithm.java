@Test public void testUnknownAlgorithm() throws Exception {
fail("expected NoSuchAlgorithmException");
assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_ALGORITHM_NAME));
}