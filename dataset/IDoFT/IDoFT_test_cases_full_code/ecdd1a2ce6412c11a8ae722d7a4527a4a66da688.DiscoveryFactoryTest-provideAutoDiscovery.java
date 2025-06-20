@Test public void provideAutoDiscovery(){
  when(runtimeContext.isDisablePeerDiscovery()).thenReturn(false);
  Discovery discovery=DiscoveryFactory.provider();
  assertThat(discovery).isNotNull().isExactlyInstanceOf(AutoDiscovery.class);
  verify(runtimeContext).isDisablePeerDiscovery();
}
