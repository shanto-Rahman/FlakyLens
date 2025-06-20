@Test public void testReadInstalledDrivers() throws Exception {
Assert.assertNotNull("There are no installed JDBC drivers",result2);
Assert.assertTrue("Name of JDBC driver is udefined",result2.hasDefined("driver-name"));
if (!result2.hasDefined("deployment-name")) {
Assert.assertTrue("Module name of JDBC driver is udefined",result2.hasDefined("driver-module-name"));
Assert.assertTrue("Module slot of JDBC driver is udefined",result2.hasDefined("module-slot"));
}
}