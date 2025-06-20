@Test public void httpsWithCustomTrustManager() throws Exception {
assertEquals(Arrays.asList("verify " + hostName),hostnameVerifier.calls);
assertEquals(Arrays.asList("checkServerTrusted [CN=" + hostName + " 1]"),trustManager.calls);
}