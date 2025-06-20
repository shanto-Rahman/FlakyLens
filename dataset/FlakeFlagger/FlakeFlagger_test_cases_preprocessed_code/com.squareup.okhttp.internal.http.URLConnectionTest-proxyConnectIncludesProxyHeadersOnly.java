/** 
 * Test which headers are sent unencrypted to the HTTP proxy. 
 */
@Test public void proxyConnectIncludesProxyHeadersOnly() throws IOException, InterruptedException {
assertEquals(Arrays.asList("verify android.com"),hostnameVerifier.calls);
}