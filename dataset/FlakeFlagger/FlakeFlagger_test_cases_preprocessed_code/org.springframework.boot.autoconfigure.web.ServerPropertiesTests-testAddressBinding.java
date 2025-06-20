@Test public void testAddressBinding() throws Exception {
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(InetAddress.getByName("127.0.0.1"),this.properties.getAddress());
}