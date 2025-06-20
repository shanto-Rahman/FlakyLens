@Test public void shouldUseWroConfigurationFoundInServletContext() throws Exception {
assertSame(config,Context.get().getConfig());
}