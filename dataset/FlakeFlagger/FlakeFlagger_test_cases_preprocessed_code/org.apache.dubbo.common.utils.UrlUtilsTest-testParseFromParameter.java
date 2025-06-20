@Test public void testParseFromParameter(){
assertEquals(localAddress + ":10000",url.getAddress());
assertEquals("root",url.getUsername());
assertEquals("alibaba",url.getPassword());
assertEquals(10000,url.getPort());
assertEquals("dubbo",url.getProtocol());
assertEquals("dubbo.test.api",url.getPath());
assertEquals("bbb",url.getParameter("aaa"));
assertEquals("ddd",url.getParameter("ccc"));
}