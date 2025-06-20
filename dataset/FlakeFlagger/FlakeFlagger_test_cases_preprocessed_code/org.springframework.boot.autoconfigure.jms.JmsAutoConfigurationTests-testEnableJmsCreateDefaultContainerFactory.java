@Test public void testEnableJmsCreateDefaultContainerFactory(){
assertEquals(DefaultJmsListenerContainerFactory.class,jmsListenerContainerFactory.getClass());
}