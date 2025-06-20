@Test public void testRegistrationWithParentContext() throws Exception {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(getObjectName("endpoint1",this.context)));
}