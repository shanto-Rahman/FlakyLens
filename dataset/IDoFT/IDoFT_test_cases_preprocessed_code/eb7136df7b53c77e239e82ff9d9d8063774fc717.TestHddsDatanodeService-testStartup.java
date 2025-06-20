@Test public void testStartup() throws IOException {
assertNotNull(service.getDatanodeDetails());
assertNotNull(service.getDatanodeDetails().getHostName());
assertFalse(service.getDatanodeStateMachine().isDaemonStopped());
assertNotNull(service.getCRLStore());
assertNull(service.getCRLStore().getStore());
}