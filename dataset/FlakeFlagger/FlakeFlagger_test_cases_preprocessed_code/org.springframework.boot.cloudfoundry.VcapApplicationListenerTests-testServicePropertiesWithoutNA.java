@Test public void testServicePropertiesWithoutNA(){
assertEquals("mysql",this.context.getEnvironment().getProperty("vcap.services.mysql.name"));
}