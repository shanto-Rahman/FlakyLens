@Test public void testAnnotationOnMissingBeanConditionWithEagerFactoryBean(){
assertFalse(this.context.containsBean("bar"));
assertTrue(this.context.containsBean("example"));
assertEquals("foo",this.context.getBean("foo"));
}