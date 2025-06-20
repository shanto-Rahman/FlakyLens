@Test public void validate() throws Exception {
  server=server();
  HttpClientConfig clientConfig=new HttpClientConfig().setKeyStorePath(getResource("clientcert-pem/client.pem").getPath()).setKeyStorePassword("ollie").setTrustStorePath(getResource("clientcert-pem/ca.crt").getPath());
  assertClientCertificateRequest(clientConfig);
  server.stop();
}
