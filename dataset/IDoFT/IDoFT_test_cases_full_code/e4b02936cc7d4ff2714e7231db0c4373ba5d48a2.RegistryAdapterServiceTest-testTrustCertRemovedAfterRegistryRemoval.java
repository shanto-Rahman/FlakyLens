@Test public void testTrustCertRemovedAfterRegistryRemoval() throws Throwable {
  List<String> trustCertList=getDocumentLinksOfType(SslTrustCertificateState.class);
  int trustCertInitialSize=trustCertList.size();
  assertEquals(1,trustCertInitialSize);
  String trustCertLink=trustCertList.get(0);
  RegistryState registryState=new RegistryState();
  registryState.customProperties=new HashMap<>();
  registryState.customProperties.put(RegistryService.REGISTRY_TRUST_CERTS_PROP_NAME,trustCertLink);
  doPatch(registryState,defaultRegistryStateLink);
  doPatch(registryState,v2RegistryStateLink);
  doPatch(registryState,dockerHubRegistryStateLink);
  doDelete(UriUtils.buildUri(host,defaultRegistryStateLink),false);
  trustCertList=getDocumentLinksOfType(SslTrustCertificateState.class);
  assertEquals(trustCertInitialSize,trustCertList.size());
  doDelete(UriUtils.buildUri(host,v2RegistryStateLink),false);
  trustCertList=getDocumentLinksOfType(SslTrustCertificateState.class);
  assertEquals(trustCertInitialSize,trustCertList.size());
  doDelete(UriUtils.buildUri(host,dockerHubRegistryStateLink),false);
  trustCertList=getDocumentLinksOfType(SslTrustCertificateState.class);
  assertEquals(trustCertInitialSize - 1,trustCertList.size());
}
