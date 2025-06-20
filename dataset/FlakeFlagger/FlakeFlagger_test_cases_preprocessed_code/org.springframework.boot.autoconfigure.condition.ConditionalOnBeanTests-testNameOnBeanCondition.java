@Test public void testNameOnBeanCondition(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}