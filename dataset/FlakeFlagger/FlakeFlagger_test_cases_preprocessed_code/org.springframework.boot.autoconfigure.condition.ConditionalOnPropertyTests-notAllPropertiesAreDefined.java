@Test public void notAllPropertiesAreDefined(){
assertFalse(this.context.containsBean("foo"));
}