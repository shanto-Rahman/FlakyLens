@Test public void testJDBCDriver() throws Exception {
Assert.assertEquals(h2MainModuleDriver.asString(),"com.h2database.h2",h2MainModuleDriver.get("driver-module-name").asString());
Assert.assertEquals(h2MainModuleDriver.asString(),"org.h2.jdbcx.JdbcDataSource",h2MainModuleDriver.get("driver-xa-datasource-class-name").asString());
Assert.assertFalse(h2MainModuleDriver.get("module-slot").isDefined());
Assert.assertEquals(h2TestModuleDriver.asString(),"com.h2database.h2",h2TestModuleDriver.get("driver-module-name").asString());
Assert.assertEquals(h2TestModuleDriver.asString(),"org.h2.jdbcx.JdbcDataSource",h2TestModuleDriver.get("driver-xa-datasource-class-name").asString());
Assert.assertEquals(h2TestModuleDriver.asString(),"test",h2TestModuleDriver.get("module-slot").asString());
}