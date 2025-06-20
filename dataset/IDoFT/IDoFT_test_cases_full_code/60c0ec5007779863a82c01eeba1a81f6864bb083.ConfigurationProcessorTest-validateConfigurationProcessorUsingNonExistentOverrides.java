@Test public void validateConfigurationProcessorUsingNonExistentOverrides(){
  File overridesFile=new File(basedir,"src/test/resources/overrides-non-existent.conf");
  ConfigurationProcessor processor=new ConfigurationProcessor("gatekeeper",overridesFile);
  exception.expect(RuntimeException.class);
  exception.expectMessage(containsString("The specified overrides configuration doesn't exist:"));
  processor.process();
}
