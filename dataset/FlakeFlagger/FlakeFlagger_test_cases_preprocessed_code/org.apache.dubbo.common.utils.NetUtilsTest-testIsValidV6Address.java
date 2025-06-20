@Test public void testIsValidV6Address(){
if (address instanceof Inet6Address) {
assertThat(NetUtils.isValidV6Address((Inet6Address)address),equalTo(true));
}
}