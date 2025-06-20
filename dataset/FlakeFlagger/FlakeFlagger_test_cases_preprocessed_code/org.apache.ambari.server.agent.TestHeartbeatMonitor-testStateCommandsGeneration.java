@Test public void testStateCommandsGeneration() throws AmbariException, InterruptedException, InvalidStateTransitionException {
Clusters clusters=injector.getInstance(Clusters.class);//RW
HeartBeatHandler handler=new HeartBeatHandler(clusters,aq,am,injector);//RW
assertTrue("HeartbeatMonitor should generate StatusCommands for host1",cmds.size() == 3);
assertEquals("HDFS",cmds.get(0).getServiceName());
assertEquals(true,containsDATANODEStatus);
assertEquals(true,containsNAMENODEStatus);
assertEquals(true,containsSECONDARY_NAMENODEStatus);
assertTrue("HeartbeatMonitor should not generate StatusCommands for host2 because it has no services",cmds.isEmpty());
}