@Test public void testRabbitTemplateWithOverrides(){
assertEquals("remote-server",connectionFactory.getHost());
assertEquals(9000,connectionFactory.getPort());
assertEquals("/vhost",connectionFactory.getVirtualHost());
}