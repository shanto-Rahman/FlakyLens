@Test public void testNotWebApplication(){
assertFalse(this.context.containsBean("foo"));
}