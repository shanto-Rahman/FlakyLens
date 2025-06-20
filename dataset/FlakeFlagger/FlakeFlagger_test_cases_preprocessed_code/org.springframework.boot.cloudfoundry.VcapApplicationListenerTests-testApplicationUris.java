@Test public void testApplicationUris(){
assertEquals("foo.cfapps.io",this.context.getEnvironment().getProperty("vcap.application.uris[0]"));
}