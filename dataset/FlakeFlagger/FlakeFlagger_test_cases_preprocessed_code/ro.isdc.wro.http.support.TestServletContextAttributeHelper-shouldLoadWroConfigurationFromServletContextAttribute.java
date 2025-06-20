@Test public void shouldLoadWroConfigurationFromServletContextAttribute() throws Exception {
Assert.assertSame(expectedConfig,filter.getConfiguration());
}