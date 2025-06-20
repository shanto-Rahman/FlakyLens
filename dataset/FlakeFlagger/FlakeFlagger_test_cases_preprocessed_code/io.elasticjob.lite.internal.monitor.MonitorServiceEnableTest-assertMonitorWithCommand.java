@Test public void assertMonitorWithCommand() throws IOException {
assertNotNull(SocketUtils.sendCommand(MonitorService.DUMP_COMMAND,MONITOR_PORT));
assertNull(SocketUtils.sendCommand("unknown_command",MONITOR_PORT));
}