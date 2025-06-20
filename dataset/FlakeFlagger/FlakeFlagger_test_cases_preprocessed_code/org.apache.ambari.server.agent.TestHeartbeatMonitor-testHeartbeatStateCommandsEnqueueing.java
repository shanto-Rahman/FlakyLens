@Test public void testHeartbeatStateCommandsEnqueueing() throws AmbariException, InterruptedException, InvalidStateTransitionException {
Clusters clusters=injector.getInstance(Clusters.class);//RW
HeartBeatHandler handler=new HeartBeatHandler(clusters,aqMock,am,injector);//RW
Thread.sleep(3 * heartbeatMonitorWakeupIntervalMS);
if (hm.isAlive()) {
fail("HeartbeatMonitor should be already stopped");
}
assertTrue("HeartbeatMonitor should generate StatusCommands for host1",cmds.size() >= 2);
assertEquals("HDFS",((StatusCommand)command).getServiceName());
}