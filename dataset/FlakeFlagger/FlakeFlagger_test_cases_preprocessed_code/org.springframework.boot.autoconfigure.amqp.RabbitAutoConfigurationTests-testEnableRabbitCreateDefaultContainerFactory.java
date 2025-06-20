@Test public void testEnableRabbitCreateDefaultContainerFactory(){
assertEquals(SimpleRabbitListenerContainerFactory.class,rabbitListenerContainerFactory.getClass());
}