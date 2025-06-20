@Test public void assertPersistConfigurationForMasterSlaveRuleWithAuthenticationAndIsOverwrite(){
  ConfigurationService configurationService=new ConfigurationService("test",regCenter);
  configurationService.persistConfiguration("sharding_db",createDataSourceConfigurations(),createMasterSlaveRuleConfiguration(),createAuthentication(),createProperties(),true);
  verify(regCenter).persist(eq("/test/config/schema/sharding_db/datasource"),ArgumentMatchers.<String>any());
  verify(regCenter).persist("/test/config/schema/sharding_db/rule",MASTER_SLAVE_RULE_YAML);
  verify(regCenter).persist("/test/config/authentication",AUTHENTICATION_YAML);
  verify(regCenter).persist("/test/config/props",PROPS_YAML);
}
