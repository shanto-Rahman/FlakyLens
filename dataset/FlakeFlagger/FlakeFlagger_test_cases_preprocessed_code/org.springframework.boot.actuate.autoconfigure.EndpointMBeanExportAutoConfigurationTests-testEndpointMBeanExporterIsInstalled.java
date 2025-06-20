@Test public void testEndpointMBeanExporterIsInstalled() throws Exception {
assertNotNull(this.context.getBean(EndpointMBeanExporter.class));
assertFalse(mbeanExporter.getServer().queryNames(getObjectName("*","*,*",this.context),null).isEmpty());
}