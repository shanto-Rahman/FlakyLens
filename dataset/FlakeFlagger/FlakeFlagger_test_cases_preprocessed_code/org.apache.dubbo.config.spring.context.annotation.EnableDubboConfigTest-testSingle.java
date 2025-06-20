@Test public void testSingle(){
Assert.assertEquals("dubbo-demo-application",applicationConfig.getName());
Assert.assertEquals("dubbo-demo-module",moduleConfig.getName());
Assert.assertEquals("zookeeper://192.168.99.100:32770",registryConfig.getAddress());
Assert.assertEquals("dubbo",protocolConfig.getName());
Assert.assertEquals(Integer.valueOf(20880),protocolConfig.getPort());
Assert.assertEquals("zookeeper://127.0.0.1:32770",monitorConfig.getAddress());
Assert.assertEquals("127.0.0.1",providerConfig.getHost());
Assert.assertEquals("netty",consumerConfig.getClient());
}