@Test public void testRabbitTemplateDefaultVirtualHost(){
assertEquals("/",connectionFactory.getVirtualHost());
}