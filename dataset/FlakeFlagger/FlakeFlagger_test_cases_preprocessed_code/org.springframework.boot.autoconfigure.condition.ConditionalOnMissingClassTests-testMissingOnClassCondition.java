@Test public void testMissingOnClassCondition(){
assertTrue(this.context.containsBean("bar"));
assertEquals("foo",this.context.getBean("foo"));
}