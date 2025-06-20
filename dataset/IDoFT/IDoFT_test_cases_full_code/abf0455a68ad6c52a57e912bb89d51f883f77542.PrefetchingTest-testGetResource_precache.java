public void testGetResource_precache() throws Exception {
  Callable<String,IOException> c=(Callable<String,IOException>)cl.loadClass("test.HelloGetResource").newInstance();
  String v=channel.call(c);
  System.out.println(v);
  verifyResourcePrecache(v);
}
