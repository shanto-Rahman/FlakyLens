/** 
 * Once the jar files are cached, ClassLoader.getResources() should return jar URLs.
 */
public void testGetResources() throws Exception {
  channel.call(new ForceJarLoad(sum1));
  channel.call(new ForceJarLoad(sum2));
  Callable<String,IOException> c=(Callable<String,IOException>)cl.loadClass("test.HelloGetResources").newInstance();
  String v=channel.call(c);
  System.out.println(v);
  String[] lines=v.split("\n");
  verifyResource(lines[0]);
  Assert.assertThat(lines[1],allOf(startsWith("jar:file:"),containsString(dir.toURI().getPath()),endsWith("::hello2")));
}
