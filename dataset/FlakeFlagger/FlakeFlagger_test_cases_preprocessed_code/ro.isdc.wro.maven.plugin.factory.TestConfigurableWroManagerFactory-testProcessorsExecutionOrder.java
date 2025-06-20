@Test public void testProcessorsExecutionOrder(){
Assert.assertFalse(list.isEmpty());
assertEquals(JSMinProcessor.class,getProcessor(iterator.next()).getClass());
assertEquals(CssImportPreProcessor.class,getProcessor(iterator.next()).getClass());
assertEquals(CssVariablesProcessor.class,getProcessor(iterator.next()).getClass());
}