@Test public void testRegistrationWithDifferentDomain() throws Exception {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(getObjectName("test-domain","endpoint1",false,this.context)));
}