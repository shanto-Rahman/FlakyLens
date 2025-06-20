@Test public void testClone() throws Exception {
  MonitoredRPCHandlerImpl monitor=new MonitoredRPCHandlerImpl();
  monitor.abort("abort RPC");
  TestParam testParam=new TestParam("param1");
  monitor.setRPC("method1",new Object[]{testParam},0);
  MonitoredRPCHandlerImpl clone=monitor.clone();
  assertEquals(clone.getDescription(),monitor.getDescription());
  assertEquals(clone.getState(),monitor.getState());
  assertEquals(clone.getStatus(),monitor.getStatus());
  assertEquals(clone.toString(),monitor.toString());
  assertEquals(clone.toMap(),monitor.toMap());
  assertEquals(clone.toJSON(),monitor.toJSON());
  monitor.markComplete("complete RPC");
  testParam.setParam("dirtyParam");
  assertEquals(clone.getDescription(),monitor.getDescription());
  assertNotEquals(clone.getState(),monitor.getState());
  assertNotEquals(clone.getStatus(),monitor.getStatus());
  monitor.setState(MonitoredTask.State.RUNNING);
  try {
    monitor.toMap();
    fail("Should not call toMap successfully, because param=null");
  }
 catch (  Exception e) {
  }
  assertNotEquals("[dirtyString]",String.valueOf(((Map<String,Object>)clone.toMap().get("rpcCall")).get("params")));
  monitor.resume("resume");
  monitor.setRPC("method2",new Object[]{new TestParam("param2")},1);
  assertNotEquals(((Map<String,Object>)clone.toMap().get("rpcCall")).get("params"),((Map<String,Object>)monitor.toMap().get("rpcCall")).get("params"));
  LOG.info(String.valueOf(clone.toMap()));
  LOG.info(String.valueOf(monitor.toMap()));
  assertNotEquals(clone.toString(),monitor.toString());
  assertNotEquals(clone.getRPCQueueTime(),monitor.getRPCQueueTime());
  assertNotEquals(clone.toMap(),monitor.toMap());
  assertNotEquals(clone.toJSON(),monitor.toJSON());
}
