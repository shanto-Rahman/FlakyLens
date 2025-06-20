@Test public void testLog() throws Throwable {
  PodState podState=createPodState();
  createLogStates(podState);
  Map<String,LogServiceState> logsMap=getPodLogs(podState);
  assertNotNull(logsMap);
  assertEquals(6,logsMap.size());
  for (int i=0; i < podState.pod.spec.containers.size(); i++) {
    Container temp=podState.pod.spec.containers.get(i);
    assertTrue(logsMap.containsKey(temp.name));
    assertEquals("test-log-" + i,new String(logsMap.get(temp.name).logs));
  }
}
