@Test public void testTomcatBinding() throws Exception {
assertEquals("%h %t '%r' %s %b",this.properties.getTomcat().getAccessLogPattern());
assertEquals("Remote-Ip",this.properties.getTomcat().getRemoteIpHeader());
assertEquals("X-Forwarded-Protocol",this.properties.getTomcat().getProtocolHeader());
assertEquals("10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",this.properties.getTomcat().getInternalProxies());
}