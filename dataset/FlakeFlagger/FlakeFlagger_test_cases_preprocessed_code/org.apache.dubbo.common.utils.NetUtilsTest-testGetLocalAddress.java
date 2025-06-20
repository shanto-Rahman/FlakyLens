@Test public void testGetLocalAddress() throws Exception {
assertNotNull(address);
assertTrue(NetUtils.isValidLocalHost(address.getHostAddress()));
}