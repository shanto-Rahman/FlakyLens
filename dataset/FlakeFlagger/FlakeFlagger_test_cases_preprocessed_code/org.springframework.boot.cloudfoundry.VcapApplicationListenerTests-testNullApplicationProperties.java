@Test public void testNullApplicationProperties(){
assertNull(this.context.getEnvironment().getProperty("vcap"));
}