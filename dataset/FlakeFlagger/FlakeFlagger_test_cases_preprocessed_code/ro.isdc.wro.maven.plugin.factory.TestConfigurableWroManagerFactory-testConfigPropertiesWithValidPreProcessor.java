@Test public void testConfigPropertiesWithValidPreProcessor(){
assertEquals(1,processorsFactory.getPreProcessors().size());
assertEquals(CssMinProcessor.class,getProcessor(processorsFactory.getPreProcessors().iterator().next()).getClass());
}