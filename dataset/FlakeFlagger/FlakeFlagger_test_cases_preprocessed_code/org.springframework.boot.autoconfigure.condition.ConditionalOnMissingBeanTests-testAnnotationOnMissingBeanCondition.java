@Test public void testAnnotationOnMissingBeanCondition(){
assertFalse(this.context.containsBean("bar"));
assertEquals("foo",this.context.getBean("foo"));
}