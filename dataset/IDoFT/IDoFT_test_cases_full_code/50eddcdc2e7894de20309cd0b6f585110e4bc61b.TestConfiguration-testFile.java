public void testFile() throws Exception {
  URL url=this.getClass().getClassLoader().getResource(ESPER_TEST_CONFIG);
  File file=new File(url.toURI());
  config.configure(file);
  TestConfigurationParser.assertFileConfig(config);
}
