@Test public void testLoadingOfExternalConfigurationFileWorksAndPrefixedConfigurationsSetRead(){
assertEquals("http://myapp-test.herokuapp.com:80",ninjaProperties.get("fullServerName"));
}