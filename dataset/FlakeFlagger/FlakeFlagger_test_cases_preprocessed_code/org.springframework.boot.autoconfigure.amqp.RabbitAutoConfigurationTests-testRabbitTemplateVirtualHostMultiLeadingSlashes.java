@Test public void testRabbitTemplateVirtualHostMultiLeadingSlashes(){
assertEquals("///foo",connectionFactory.getVirtualHost());
}