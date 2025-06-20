@Test public void differentAddressConnectionNotReturned() throws Exception {
assertNull(pool.get(spdyAddress));
}