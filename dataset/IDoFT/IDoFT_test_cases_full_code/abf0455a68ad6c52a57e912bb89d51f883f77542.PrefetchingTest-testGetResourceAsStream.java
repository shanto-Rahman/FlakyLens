public void testGetResourceAsStream() throws Exception {
  Callable<String,IOException> c=(Callable<String,IOException>)cl.loadClass("test.HelloGetResourceAsStream").newInstance();
  String v=channel.call(c);
  assertEquals("hello",v);
}
