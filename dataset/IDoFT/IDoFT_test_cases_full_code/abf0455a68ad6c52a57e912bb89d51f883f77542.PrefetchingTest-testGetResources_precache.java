/** 
 * Unlike  {@link #testGetResources()}, the URL should begin with file:... before the jar file gets cached
 */
public void testGetResources_precache() throws Exception {
  Callable<String,IOException> c=(Callable<String,IOException>)cl.loadClass("test.HelloGetResources").newInstance();
  String v=channel.call(c);
  System.out.println(v);
  String[] lines=v.split("\n");
  assertTrue(lines[0],lines[0].startsWith("file:"));
  assertTrue(lines[1],lines[1].startsWith("file:"));
  assertTrue(lines[0],lines[0].endsWith("::hello"));
  assertTrue(lines[1],lines[1].endsWith("::hello2"));
}
