@Test public void testOnClassConditionWithXml(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}