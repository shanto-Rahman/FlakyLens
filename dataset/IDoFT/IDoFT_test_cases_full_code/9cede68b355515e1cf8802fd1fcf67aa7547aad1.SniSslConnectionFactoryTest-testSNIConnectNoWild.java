@Test public void testSNIConnectNoWild() throws Exception {
  start("src/test/resources/keystore_sni_nowild.p12");
  String response=getResponse("www.acme.org",null);
  assertThat(response,Matchers.containsString("X-HOST: www.acme.org"));
  assertThat(response,Matchers.containsString("X-Cert: OU=default"));
  response=getResponse("www.example.com",null);
  assertThat(response,Matchers.containsString("X-HOST: www.example.com"));
  assertThat(response,Matchers.containsString("X-Cert: OU=example"));
}
