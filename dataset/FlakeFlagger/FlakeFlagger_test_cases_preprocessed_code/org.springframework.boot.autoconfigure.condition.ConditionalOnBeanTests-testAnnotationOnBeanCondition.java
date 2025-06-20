@Test public void testAnnotationOnBeanCondition(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}