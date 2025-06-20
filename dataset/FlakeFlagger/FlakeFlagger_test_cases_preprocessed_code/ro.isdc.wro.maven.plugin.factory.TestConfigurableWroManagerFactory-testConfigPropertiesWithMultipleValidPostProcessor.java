@Test public void testConfigPropertiesWithMultipleValidPostProcessor(){
assertEquals(2,processorsFactory.getPostProcessors().size());
assertEquals(JSMinProcessor.class,getProcessor(processorsFactory.getPostProcessors().iterator().next()).getClass());
}