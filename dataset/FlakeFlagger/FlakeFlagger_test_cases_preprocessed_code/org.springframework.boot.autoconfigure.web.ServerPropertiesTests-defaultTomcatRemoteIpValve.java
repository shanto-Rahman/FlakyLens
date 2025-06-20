@Test public void defaultTomcatRemoteIpValve() throws Exception {
assertEquals(1,container.getValves().size());
assertThat(valve,instanceOf(RemoteIpValve.class));
assertEquals("x-forwarded-proto",remoteIpValve.getProtocolHeader());
assertEquals("x-forwarded-for",remoteIpValve.getRemoteIpHeader());
assertEquals(expectedInternalProxies,remoteIpValve.getInternalProxies());
}