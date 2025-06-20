@Test public void testIPv4SlashMatch() throws UnknownHostException {
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.1")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.1.1")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.1.0.2")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.47")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.48")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.49")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.50")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.51")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("127.0.0.52")));
}