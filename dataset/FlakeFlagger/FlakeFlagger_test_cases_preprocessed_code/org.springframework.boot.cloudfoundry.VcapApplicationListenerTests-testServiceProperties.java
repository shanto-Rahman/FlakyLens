@Test public void testServiceProperties(){
assertEquals("mysql",this.context.getEnvironment().getProperty("vcap.services.mysql.name"));
}