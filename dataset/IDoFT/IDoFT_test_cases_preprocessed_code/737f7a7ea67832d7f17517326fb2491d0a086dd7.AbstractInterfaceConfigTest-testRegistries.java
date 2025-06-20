@Test public void testRegistries() throws Exception {
TestCase.assertEquals(1,interfaceConfig.getRegistries().size());
TestCase.assertSame(registryConfig,interfaceConfig.getRegistries().get(0));
}