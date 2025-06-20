@Test public void defaultConstructor(){
  DiscoveryFactory discoveryFactory=new DiscoveryFactory();
  assertThat(discoveryFactory).isNotNull();
  verify(runtimeContext).isDisablePeerDiscovery();
}
