@Test public void testClassOnBeanClassNameCondition(){
assertTrue(this.context.containsBean("bar"));
assertEquals("bar",this.context.getBean("bar"));
}