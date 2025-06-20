@Test public void testApplicationProperties(){
assertEquals("bb7935245adf3e650dfb7c58a06e9ece",this.context.getEnvironment().getProperty("vcap.application.instance_id"));
}