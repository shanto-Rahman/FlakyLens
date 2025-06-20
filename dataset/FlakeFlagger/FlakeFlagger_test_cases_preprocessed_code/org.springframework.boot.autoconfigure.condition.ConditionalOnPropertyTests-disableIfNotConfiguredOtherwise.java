@Test public void disableIfNotConfiguredOtherwise(){
assertFalse(this.context.containsBean("foo"));
}