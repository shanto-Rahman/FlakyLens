@Test public void testEndpointMBeanExporterIsNotInstalledIfNestedInManagedResource() throws Exception {
assertNotNull(this.context.getBean(EndpointMBeanExporter.class));
assertTrue(mbeanExporter.getServer().queryNames(getObjectName("*","*,*",this.context),null).isEmpty());
}