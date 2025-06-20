@Test public void validateConfigurationProcessor(){
  ConfigurationProcessor processor=new ConfigurationProcessor("gatekeeper");
  com.typesafe.config.Config config=processor.process();
  assertEquals("dev-settle-token",config.getString("approver.settle.token"));
  assertEquals("dev-jira-username",config.getString("jira.username"));
  assertEquals("dev-jira-password",config.getString("jira.password"));
  assertEquals("caring",config.getString("sharing"));
  assertEquals(123,config.getInt("y"));
}
