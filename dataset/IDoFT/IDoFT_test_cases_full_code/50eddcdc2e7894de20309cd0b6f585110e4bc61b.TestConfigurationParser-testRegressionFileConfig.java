public void testRegressionFileConfig() throws Exception {
  Configuration config=new Configuration();
  URL url=this.getClass().getClassLoader().getResource(TestConfiguration.ESPER_TEST_CONFIG);
  ConfigurationParser.doConfigure(config,url.openStream(),url.toString());
  assertFileConfig(config);
}
