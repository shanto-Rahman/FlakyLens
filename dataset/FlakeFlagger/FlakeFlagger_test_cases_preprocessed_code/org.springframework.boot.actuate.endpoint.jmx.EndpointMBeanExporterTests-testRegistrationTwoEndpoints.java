@Test public void testRegistrationTwoEndpoints() throws Exception {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(getObjectName("endpoint1",this.context)));
assertNotNull(mbeanExporter.getServer().getMBeanInfo(getObjectName("endpoint2",this.context)));
}