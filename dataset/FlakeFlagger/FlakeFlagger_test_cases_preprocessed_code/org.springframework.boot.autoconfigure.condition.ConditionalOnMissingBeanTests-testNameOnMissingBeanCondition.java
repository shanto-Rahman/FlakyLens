@Test public void testNameOnMissingBeanCondition(){
assertFalse(this.context.containsBean("bar"));
assertEquals("foo",this.context.getBean("foo"));
}