@Test public void testParseUrl(){
assertEquals(localAddress + ":9090",url.getAddress());
assertEquals("root",url.getUsername());
assertEquals("alibaba",url.getPassword());
assertEquals("dubbo.test.api",url.getPath());
assertEquals(9090,url.getPort());
assertEquals("remote",url.getProtocol());
}