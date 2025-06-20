@Test public void sslCiphersConfiguration() throws Exception {
assertThat(sslConnector.getSslContextFactory().getIncludeCipherSuites(),equalTo(new String[]{"ALPHA","BRAVO","CHARLIE"}));
}