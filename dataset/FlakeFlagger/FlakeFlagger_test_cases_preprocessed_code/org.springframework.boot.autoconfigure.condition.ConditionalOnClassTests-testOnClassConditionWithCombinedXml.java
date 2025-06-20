@Test public void testOnClassConditionWithCombinedXml(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}