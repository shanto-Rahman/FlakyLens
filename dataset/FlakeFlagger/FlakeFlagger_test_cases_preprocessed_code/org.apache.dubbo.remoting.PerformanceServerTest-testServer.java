@Test public void testServer() throws Exception {
if (PerformanceUtils.getProperty("port",null) == null) {
}
if (telnet) statTelnetServer(port + 1);
server=statServer();//RW
}