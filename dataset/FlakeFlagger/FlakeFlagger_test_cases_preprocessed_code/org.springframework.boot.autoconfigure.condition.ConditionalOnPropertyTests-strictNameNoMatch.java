@Test public void strictNameNoMatch(){
assertFalse(this.context.containsBean("foo"));
}