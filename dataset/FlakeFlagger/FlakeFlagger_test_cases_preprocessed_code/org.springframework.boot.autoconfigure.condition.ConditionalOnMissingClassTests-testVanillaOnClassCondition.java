@Test public void testVanillaOnClassCondition(){
assertFalse(this.context.containsBean("bar"));
assertEquals("foo",this.context.getBean("foo"));
}