@Test public void createConfigFromResourceFile() throws MojoExecutionException, URISyntaxException, JsonProcessingException {
File testConfigJSON=new File(configFile.toURI());//RO
assertThat(testConfig.getFullConfig()).isEqualTo("{\"executionID\":\"test-execution\",\"jmeterDirectoryPath\":null,\"runtimeJarName\":null,\"resultsOutputIsCSVFormat\":false,\"generateReports\":false,\"resultFilesLocations\":[],\"propertiesMap\":null,\"jmeterWorkingDirectoryPath\":null}");
}