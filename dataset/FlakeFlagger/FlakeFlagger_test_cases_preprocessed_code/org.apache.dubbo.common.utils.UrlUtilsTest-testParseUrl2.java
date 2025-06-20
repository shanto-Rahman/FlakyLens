@Test public void testParseUrl2(){
assertEquals("192.168.0.1:10000",url.getAddress());
assertEquals("root",url.getUsername());
assertEquals("alibaba",url.getPassword());
assertEquals(10000,url.getPort());
assertEquals("dubbo",url.getProtocol());
assertEquals("192.168.0.2" + "," + "192.168.0.3",url.getParameter("backup"));
}