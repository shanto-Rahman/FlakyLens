@Test public void enabledIfNotConfiguredOtherwiseWithConfigDifferentCase(){
assertFalse(this.context.containsBean("foo"));
}