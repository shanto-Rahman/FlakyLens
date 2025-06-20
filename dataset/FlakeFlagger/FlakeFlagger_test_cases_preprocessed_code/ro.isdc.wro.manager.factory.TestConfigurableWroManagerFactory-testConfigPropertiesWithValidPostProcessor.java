@Test public void testConfigPropertiesWithValidPostProcessor(){
assertEquals(1,processorsFactory.getPostProcessors().size());
assertEquals(JSMinProcessor.class,((ProcessorDecorator)processorsFactory.getPostProcessors().iterator().next()).getDecoratedObject().getClass());
}