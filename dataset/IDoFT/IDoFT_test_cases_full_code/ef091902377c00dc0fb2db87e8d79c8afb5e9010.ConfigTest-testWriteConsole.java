@Test public void testWriteConsole() throws Exception {
  Config.Builder builder=new Config.Builder();
  builder.addClasspathEntry(new File("foo1.jar"));
  builder.addClasspathEntry(new File(tmp,"foo2.jar"));
  builder.addFramework("Foundation");
  builder.addFramework("AppKit");
  builder.addLib(new Config.Lib("dl",true));
  builder.addLib(new Config.Lib("libs/libmy.a",true));
  builder.addLib(new Config.Lib("libs/foo.o",true));
  builder.addLib(new Config.Lib("/usr/lib/libbar.a",false));
  builder.addResource(new Resource(new File("/tmp/wd/resources")));
  builder.addResource(new Resource(new File("/usr/share/resources")));
  builder.addResource(new Resource(new File("/tmp/wd"),null).include("data/**/*"));
  builder.addResource(new Resource(null,null).include("videos/**/*.avi"));
  builder.addResource(new Resource(new File("/tmp/wd/resources"),"data").include("**/*.png").exclude("**/foo.png").flatten(true));
  builder.addForceLinkClass("javax.**.*");
  builder.os(OS.macosx);
  builder.archs(Arch.x86,Arch.x86_64);
  StringWriter out=new StringWriter();
  builder.write(out,wd);
  assertEquals(IOUtils.toString(getClass().getResourceAsStream("ConfigTest.console.xml")),out.toString());
}
