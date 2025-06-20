@Test public void mongoHealthIndicator(){
assertEquals(1,beans.size());
assertEquals(MongoHealthIndicator.class,beans.values().iterator().next().getClass());
}