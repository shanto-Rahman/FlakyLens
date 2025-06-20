@Test public void validateConfigurationProcessor(){
assertEquals("dev-settle-token",config.getString("approver.settle.token"));
assertEquals("dev-jira-username",config.getString("jira.username"));
assertEquals("dev-jira-password",config.getString("jira.password"));
assertEquals("caring",config.getString("sharing"));
assertEquals(123,config.getInt("y"));
}