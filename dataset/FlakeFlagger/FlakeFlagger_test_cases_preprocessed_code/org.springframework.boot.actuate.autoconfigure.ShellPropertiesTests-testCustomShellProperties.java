@Test public void testCustomShellProperties() throws Exception {
String uuid=lifeCycle.getConfig().getProperty("test.uuid");//RW
assertEquals(TestShellConfiguration.uuid,uuid);//RW
}