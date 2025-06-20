@Test public void pkcs12KeyStoreAndTrustStore() throws Exception {
keyStore.load(new FileInputStream(new File("src/test/resources/test.p12")),"secret".toCharArray());//RO
assertThat(getResponse(getLocalUrl("https","/test.txt"),requestFactory),equalTo("test"));
}