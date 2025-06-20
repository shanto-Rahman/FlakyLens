@Test public void testStartup() throws IOException {
  service=HddsDatanodeService.createHddsDatanodeService(args);
  service.start(conf);
  assertNotNull(service.getDatanodeDetails());
  assertNotNull(service.getDatanodeDetails().getHostName());
  assertFalse(service.getDatanodeStateMachine().isDaemonStopped());
  assertNotNull(service.getCRLStore());
  service.stop();
  assertNull(service.getCRLStore().getStore());
  service.join();
  service.close();
}
