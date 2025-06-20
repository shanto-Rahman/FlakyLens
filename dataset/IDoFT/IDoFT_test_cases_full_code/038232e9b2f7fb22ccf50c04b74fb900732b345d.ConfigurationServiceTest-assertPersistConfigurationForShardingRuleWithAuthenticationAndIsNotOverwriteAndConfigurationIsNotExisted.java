@Test public void assertPersistConfigurationForShardingRuleWithAuthenticationAndIsNotOverwriteAndConfigurationIsNotExisted(){
  ConfigurationService configurationService=new ConfigurationService("test",regCenter);
  configurationService.persistConfiguration("sharding_db",createDataSourceConfigurations(),createShardingRuleConfiguration(),createAuthentication(),createProperties(),false);
  verify(regCenter).persist(eq("/test/config/schema/sharding_db/datasource"),ArgumentMatchers.<String>any());
  verify(regCenter).persist("/test/config/schema/sharding_db/rule",SHARDING_RULE_YAML);
  verify(regCenter).persist("/test/config/authentication",AUTHENTICATION_YAML);
  verify(regCenter).persist("/test/config/props",PROPS_YAML);
}
