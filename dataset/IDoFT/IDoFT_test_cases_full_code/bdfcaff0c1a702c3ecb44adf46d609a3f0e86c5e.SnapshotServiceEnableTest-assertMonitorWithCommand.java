@Test public void assertMonitorWithCommand() throws IOException {
  assertNotNull(SocketUtils.sendCommand(SnapshotService.DUMP_COMMAND + getJobName(),DUMP_PORT));
  assertNull(SocketUtils.sendCommand("unknown_command",DUMP_PORT));
}
