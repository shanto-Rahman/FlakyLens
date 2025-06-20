@Test public void testRabbitTemplateEmptyVirtualHost(){
assertEquals("/",connectionFactory.getVirtualHost());
}