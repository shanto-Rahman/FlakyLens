@Test public void testConfigPropertiesWithValidPreProcessor(){
assertEquals(1,list.size());
assertEquals(CssMinProcessor.class,list.iterator().next().getClass());
}