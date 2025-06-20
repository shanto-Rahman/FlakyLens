@Test public void testGetLocalSocketAddress() throws Exception {
assertTrue(address.getAddress().isAnyLocalAddress());
assertEquals(address.getPort(),12345);
assertEquals(address.getHostName(),"dubbo-addr");
assertEquals(address.getPort(),12345);
}