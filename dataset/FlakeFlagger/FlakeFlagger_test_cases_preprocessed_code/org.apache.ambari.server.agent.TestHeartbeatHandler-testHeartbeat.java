@Test public void testHeartbeat() throws Exception {
assertEquals(HostState.HEALTHY,hostObject.getState());
assertEquals(0,aq.dequeueAll(hostname).size());
}