@Test(expected=IOException.class) public void assertMonitorWithDumpCommand() throws IOException {
  SocketUtils.sendCommand(SnapshotService.DUMP_COMMAND,DUMP_PORT - 1);
}
