@Test public void testDefaultClassAnnonation(){
assertNotNull(relevantMethod);
assertEquals(SwimmingPoolImpl.class,spClass);
assertEquals(SwimmingPoolImpl.class,classViaImplicitRules);
}