@Test public void testProcessorsExecutionOrder(){
assertEquals(JSMinProcessor.class,list.get(0).getClass());
assertEquals(CssImportPreProcessor.class,list.get(1).getClass());
assertEquals(CssVariablesProcessor.class,list.get(2).getClass());
}