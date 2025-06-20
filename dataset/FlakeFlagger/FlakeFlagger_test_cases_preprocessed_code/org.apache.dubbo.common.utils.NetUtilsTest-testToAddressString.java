@Test public void testToAddressString() throws Exception {
assertThat(NetUtils.toAddressString(socketAddress),equalTo("dubbo:1234"));
}