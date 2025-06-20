@Test public void provideDisabledAutoDiscovery(){
  when(runtimeContext.isDisablePeerDiscovery()).thenReturn(true);
  Discovery discovery=DiscoveryFactory.provider();
  assertThat(discovery).isNotNull().isExactlyInstanceOf(DisabledAutoDiscovery.class);
  verify(runtimeContext).isDisablePeerDiscovery();
  verify(runtimeContext).getPeers();
}
