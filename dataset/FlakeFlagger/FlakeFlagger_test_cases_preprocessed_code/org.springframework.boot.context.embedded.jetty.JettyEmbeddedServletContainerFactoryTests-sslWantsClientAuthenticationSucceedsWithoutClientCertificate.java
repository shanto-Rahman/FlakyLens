@Test public void sslWantsClientAuthenticationSucceedsWithoutClientCertificate() throws Exception {
assertThat(getResponse(getLocalUrl("https","/test.txt"),requestFactory),equalTo("test"));
}