@Test public void testBinder(){
Assert.assertEquals("hello",applicationConfig.getName());
Assert.assertEquals("world",applicationConfig.getOwner());
Assert.assertEquals("10.20.153.17",registryConfig.getAddress());
Assert.assertEquals(Integer.valueOf(20881),protocolConfig.getPort());
}