@Test public void defaultBitronixServerId() throws UnknownHostException {
assertThat(serverId,is(equalTo(InetAddress.getLocalHost().getHostAddress())));
}