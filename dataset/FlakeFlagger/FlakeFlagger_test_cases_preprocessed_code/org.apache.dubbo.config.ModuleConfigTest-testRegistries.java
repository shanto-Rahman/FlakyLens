@Test public void testRegistries() throws Exception {
assertThat(module.getRegistries(),Matchers.<RegistryConfig>hasSize(1));
assertThat(module.getRegistries(),contains(registry));
}