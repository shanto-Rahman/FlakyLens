@Test public void testEndpointMBeanExporterWithProperties() throws IntrospectionException, InstanceNotFoundException, MalformedObjectNameException, ReflectionException {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(ObjectNameManager.getInstance(getObjectName("test-domain","healthEndpoint",this.context).toString() + ",key1=value1,key2=value2")));
}