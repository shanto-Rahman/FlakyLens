@Test public void testRabbitTemplateVirtualHostNoLeadingSlash(){
assertEquals("foo",connectionFactory.getVirtualHost());
}