@Test public void shouldFindConfigurableProviders(){
  victim=ProviderFinder.of(ConfigurableProvider.class);
  assertEquals(1,victim.find().size());
}
