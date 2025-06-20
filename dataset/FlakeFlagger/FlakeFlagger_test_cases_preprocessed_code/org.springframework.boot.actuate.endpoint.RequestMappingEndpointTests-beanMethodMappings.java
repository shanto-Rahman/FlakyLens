@Test public void beanMethodMappings(){
assertEquals(1,result.size());
assertTrue(result.keySet().iterator().next().contains("/dump"));
assertTrue(handler.containsKey("method"));
}