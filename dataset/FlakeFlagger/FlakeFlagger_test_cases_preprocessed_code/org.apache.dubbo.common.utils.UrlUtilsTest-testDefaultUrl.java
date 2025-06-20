@Test public void testDefaultUrl(){
assertEquals(localAddress + ":9090",url.getAddress());
assertEquals(9090,url.getPort());
assertEquals("dubbo",url.getProtocol());
assertNull(url.getUsername());
assertNull(url.getPassword());
assertNull(url.getPath());
}