@Test public void testIPv6PrefixMatch() throws UnknownHostException {
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFF:45")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("127.0.0.2")));
Assert.assertFalse(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFF:46")));
Assert.assertTrue(handler.isAllowed(InetAddress.getByName("FE45:0:0:0:0:AAA:FFFb:46")));
}