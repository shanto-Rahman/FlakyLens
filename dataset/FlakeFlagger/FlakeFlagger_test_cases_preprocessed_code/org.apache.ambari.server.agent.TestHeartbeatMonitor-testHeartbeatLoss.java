@Test public void testHeartbeatLoss() throws AmbariException, InterruptedException, InvalidStateTransitionException {
Clusters fsm=injector.getInstance(Clusters.class);//RW
HeartBeatHandler handler=new HeartBeatHandler(fsm,aq,am,injector);//RW
Thread.sleep(1);
assertEquals(fsm.getHost(hostname).getState(),HostState.HEARTBEAT_LOST);
}