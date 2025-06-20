@Test public void testSingle() throws IOException {
Assert.assertEquals("dubbo-demo-application",applicationConfig.getName());
Assert.assertEquals("dubbo-demo-module",moduleConfig.getName());
Assert.assertEquals("zookeeper://192.168.99.100:32770",registryConfig.getAddress());
Assert.assertEquals("dubbo",protocolConfig.getName());
Assert.assertEquals(Integer.valueOf(20880),protocolConfig.getPort());
}