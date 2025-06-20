@Test public void sslNeedsClientAuthenticationSucceedsWithClientCertificate() throws Exception {
keyStore.load(new FileInputStream(new File("src/test/resources/test.jks")),"secret".toCharArray());//RO
assertThat(getResponse(getLocalUrl("https","/test.txt"),requestFactory),equalTo("test"));
}