@Test(timeout=10000) public void testSimpleLocalAllocation() throws IOException, InterruptedException {
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority priority1=Priority.newInstance(1);
    String[] hosts1=new String[]{HOST1};
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1=new Object();
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,hosts1,priority1,clientCookie1);
    tsWrapper.awaitLocalTaskAllocations(1);
    verify(tsWrapper.mockAppCallback).taskAllocated(eq(task1),eq(clientCookie1),any(Container.class));
    assertEquals(1,tsWrapper.ts.dagStats.getNumLocalAllocations());
    assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST1).get());
  }
  finally {
    tsWrapper.shutdown();
  }
}
