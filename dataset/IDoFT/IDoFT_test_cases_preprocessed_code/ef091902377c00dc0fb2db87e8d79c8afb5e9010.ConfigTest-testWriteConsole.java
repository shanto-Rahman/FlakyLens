@Test public void testWriteConsole() throws Exception {
builder.addClasspathEntry(new File("foo1.jar"));//RO
builder.addClasspathEntry(new File(tmp,"foo2.jar"));
builder.addResource(new Resource(new File("/tmp/wd/resources")));//RO
builder.addResource(new Resource(new File("/usr/share/resources")));//RO
builder.addResource(new Resource(new File("/tmp/wd"),null).include("data/**/*"));//RO
builder.addResource(new Resource(new File("/tmp/wd/resources"),"data").include("**/*.png").exclude("**/foo.png").flatten(true));//RO
assertEquals(IOUtils.toString(getClass().getResourceAsStream("ConfigTest.console.xml")),out.toString());
}