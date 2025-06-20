@Test public void testIPv4ExactMatch() throws UnknownHostException {
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.1")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
}