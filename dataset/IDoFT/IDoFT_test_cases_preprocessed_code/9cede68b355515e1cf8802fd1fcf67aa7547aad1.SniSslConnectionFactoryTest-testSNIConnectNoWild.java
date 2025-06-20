@Test public void testSNIConnectNoWild() throws Exception {
assertThat(response,Matchers.containsString("X-HOST: www.acme.org"));
assertThat(response,Matchers.containsString("X-Cert: OU=default"));
assertThat(response,Matchers.containsString("X-HOST: www.example.com"));
assertThat(response,Matchers.containsString("X-Cert: OU=example"));
}