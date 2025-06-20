@Test public void testMissingOnClassCondition(){
assertFalse(this.context.containsBean("bar"));
assertEquals("foo",this.context.getBean("foo"));
}