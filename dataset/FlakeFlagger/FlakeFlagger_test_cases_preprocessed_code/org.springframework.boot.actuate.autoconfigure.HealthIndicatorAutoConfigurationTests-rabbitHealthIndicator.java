@Test public void rabbitHealthIndicator(){
assertEquals(1,beans.size());
assertEquals(RabbitHealthIndicator.class,beans.values().iterator().next().getClass());
}