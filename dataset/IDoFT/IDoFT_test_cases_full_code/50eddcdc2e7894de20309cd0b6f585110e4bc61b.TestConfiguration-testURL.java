public void testURL() throws Exception {
  URL url=this.getClass().getClassLoader().getResource(ESPER_TEST_CONFIG);
  config.configure(url);
  TestConfigurationParser.assertFileConfig(config);
}
