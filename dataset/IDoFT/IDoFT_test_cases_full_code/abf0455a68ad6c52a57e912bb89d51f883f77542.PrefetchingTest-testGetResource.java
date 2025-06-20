public void testGetResource() throws Exception {
  channel.call(new ForceJarLoad(sum1));
  channel.call(new ForceJarLoad(sum2));
  Callable<String,IOException> c=(Callable<String,IOException>)cl.loadClass("test.HelloGetResource").newInstance();
  String v=channel.call(c);
  System.out.println(v);
  verifyResource(v);
}
