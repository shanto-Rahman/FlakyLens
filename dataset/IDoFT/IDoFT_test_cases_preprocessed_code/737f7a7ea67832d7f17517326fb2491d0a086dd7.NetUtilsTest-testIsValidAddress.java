@Test public void testIsValidAddress() throws Exception {
assertFalse(NetUtils.isValidAddress((InetAddress)null));
assertFalse(NetUtils.isValidAddress(address));
assertFalse(NetUtils.isValidAddress(address));
assertFalse(NetUtils.isValidAddress(address));
assertFalse(NetUtils.isValidAddress(address));
assertTrue(NetUtils.isValidAddress(address));
}