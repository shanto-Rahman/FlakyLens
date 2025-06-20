@Test public void enabledIfNotConfiguredOtherwiseWithConfig(){
assertFalse(this.context.containsBean("foo"));
}