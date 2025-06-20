@Test(timeout=10000) public void testSimpleNoLocalityAllocation() throws IOException, InterruptedException {
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority priority1=Priority.newInstance(1);
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1=new Object();
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,null,priority1,clientCookie1);
    tsWrapper.awaitTotalTaskAllocations(1);
    verify(tsWrapper.mockAppCallback).taskAllocated(eq(task1),eq(clientCookie1),any(Container.class));
    assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
  }
  finally {
    tsWrapper.shutdown();
  }
}
