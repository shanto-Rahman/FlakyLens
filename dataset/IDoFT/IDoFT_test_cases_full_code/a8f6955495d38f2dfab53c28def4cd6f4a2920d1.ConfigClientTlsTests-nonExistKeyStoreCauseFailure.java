@Test(expected=IllegalStateException.class) public void nonExistKeyStoreCauseFailure(){
  TlsConfigClientRunner client=createConfigClient(false);
  enableTlsClient(client);
  client.setKeyStore(new File("nonExistFile"));
  client.start();
}
