@Test @SuppressWarnings("deprecation") public void testPriority() throws Exception {
  Configuration conf=new Configuration();
  final String namespace="ns";
  conf.set(namespace + "." + DecayRpcScheduler.IPC_FCQ_DECAYSCHEDULER_PERIOD_KEY,"99999999");
  conf.set(namespace + "." + DecayRpcScheduler.IPC_FCQ_DECAYSCHEDULER_THRESHOLDS_KEY,"25, 50, 75");
  scheduler=new DecayRpcScheduler(4,namespace,conf);
  assertEquals(0,getPriorityIncrementCallCount("A"));
  assertEquals(3,getPriorityIncrementCallCount("A"));
  assertEquals(0,getPriorityIncrementCallCount("B"));
  assertEquals(1,getPriorityIncrementCallCount("B"));
  assertEquals(0,getPriorityIncrementCallCount("C"));
  assertEquals(0,getPriorityIncrementCallCount("C"));
  assertEquals(1,getPriorityIncrementCallCount("A"));
  assertEquals(1,getPriorityIncrementCallCount("A"));
  assertEquals(2,getPriorityIncrementCallCount("A"));
  assertEquals(2,getPriorityIncrementCallCount("A"));
  MBeanServer mbs=ManagementFactory.getPlatformMBeanServer();
  ObjectName mxbeanName=new ObjectName("Hadoop:service=" + namespace + ",name=DecayRpcScheduler");
  String cvs1=(String)mbs.getAttribute(mxbeanName,"CallVolumeSummary");
  assertTrue("Get expected JMX of CallVolumeSummary before decay",cvs1.equals("{\"A\":6,\"B\":2,\"C\":2}"));
  scheduler.forceDecay();
  String cvs2=(String)mbs.getAttribute(mxbeanName,"CallVolumeSummary");
  assertTrue("Get expected JMX for CallVolumeSummary after decay",cvs2.equals("{\"A\":3,\"B\":1,\"C\":1}"));
}
