@Test public void testClassOnBeanCondition(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}