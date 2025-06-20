@Test public void testResourceNotExists(){
assertFalse(this.context.containsBean("foo"));
}