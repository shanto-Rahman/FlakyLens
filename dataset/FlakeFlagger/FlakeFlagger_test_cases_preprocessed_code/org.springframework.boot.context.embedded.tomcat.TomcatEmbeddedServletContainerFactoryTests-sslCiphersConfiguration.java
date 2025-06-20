@Test public void sslCiphersConfiguration() throws Exception {
assertThat(jsseProtocol.getCiphers(),equalTo("ALPHA,BRAVO,CHARLIE"));
}