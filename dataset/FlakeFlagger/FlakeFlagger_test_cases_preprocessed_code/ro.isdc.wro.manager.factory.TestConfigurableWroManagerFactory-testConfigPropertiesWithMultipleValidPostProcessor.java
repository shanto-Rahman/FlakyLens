@Test public void testConfigPropertiesWithMultipleValidPostProcessor(){
assertEquals(2,processorsFactory.getPostProcessors().size());
assertEquals(JSMinProcessor.class,((ProcessorDecorator)processorsFactory.getPostProcessors().iterator().next()).getDecoratedObject().getClass());
}