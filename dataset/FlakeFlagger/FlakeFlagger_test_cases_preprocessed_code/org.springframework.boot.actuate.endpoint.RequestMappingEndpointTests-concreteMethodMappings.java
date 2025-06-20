@Test public void concreteMethodMappings(){
assertEquals(1,result.size());
assertTrue(result.keySet().iterator().next().contains("/dump"));
assertTrue(handler.containsKey("method"));
}