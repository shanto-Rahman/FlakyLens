@Test public void createConfigFromResourceFile() throws MojoExecutionException, URISyntaxException, JsonProcessingException {
  URL configFile=this.getClass().getResource(testConfigFile);
  File testConfigJSON=new File(configFile.toURI());
  TestConfigurationWrapper testConfig=new TestConfigurationWrapper(testConfigJSON,"test-execution");
  assertThatJson(testConfig.getFullConfig()).isEqualTo("{\"executionID\":\"test-execution\",\"jmeterDirectoryPath\":null,\"runtimeJarName\":null,\"resultsOutputIsCSVFormat\":false,\"generateReports\":false,\"resultFilesLocations\":[],\"propertiesMap\":null,\"jmeterWorkingDirectoryPath\":null}");
}
