@Test public void testOnMissingBeanType() throws Exception {
assertFalse(this.context.containsBean("bar"));
}