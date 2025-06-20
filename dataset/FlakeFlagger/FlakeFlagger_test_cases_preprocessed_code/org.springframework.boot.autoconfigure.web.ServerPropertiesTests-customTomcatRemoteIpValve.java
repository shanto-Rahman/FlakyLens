@Test public void customTomcatRemoteIpValve() throws Exception {
assertEquals(1,container.getValves().size());
assertThat(valve,instanceOf(RemoteIpValve.class));
assertEquals("x-my-protocol-header",remoteIpValve.getProtocolHeader());
assertEquals("x-my-remote-ip-header",remoteIpValve.getRemoteIpHeader());
assertEquals("x-my-forward-port",remoteIpValve.getPortHeader());
assertEquals("192.168.0.1",remoteIpValve.getInternalProxies());
}