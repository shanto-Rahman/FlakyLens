@Test public void testRegistries() throws Exception {
  ModuleConfig module=new ModuleConfig();
  RegistryConfig registry=new RegistryConfig();
  module.setRegistries(Collections.singletonList(registry));
  assertThat(module.getRegistries(),Matchers.<RegistryConfig>hasSize(1));
  assertThat(module.getRegistries(),contains(registry));
}
