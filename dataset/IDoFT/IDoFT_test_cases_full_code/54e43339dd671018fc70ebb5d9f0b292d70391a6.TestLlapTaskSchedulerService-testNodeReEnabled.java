@Test(timeout=10000) public void testNodeReEnabled() throws InterruptedException, IOException {
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper(1000l);
  try {
    Priority priority1=Priority.newInstance(1);
    String[] hosts1=new String[]{HOST1};
    String[] hosts2=new String[]{HOST2};
    String[] hosts3=new String[]{HOST3};
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1=new Object();
    TezTaskAttemptID task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie2=new Object();
    TezTaskAttemptID task3=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie3=new Object();
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,hosts1,priority1,clientCookie1);
    tsWrapper.allocateTask(task2,hosts2,priority1,clientCookie2);
    tsWrapper.allocateTask(task3,hosts3,priority1,clientCookie3);
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun();
      if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 3) {
        break;
      }
    }
    verify(tsWrapper.mockAppCallback,times(3)).taskAllocated(any(Object.class),any(Object.class),any(Container.class));
    assertEquals(3,tsWrapper.ts.dagStats.getNumLocalAllocations());
    assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
    assertEquals(3,tsWrapper.ts.dagStats.getNumTotalAllocations());
    tsWrapper.resetAppCallback();
    tsWrapper.rejectExecution(task1);
    tsWrapper.rejectExecution(task2);
    tsWrapper.rejectExecution(task3);
    assertEquals(3,tsWrapper.ts.dagStats.getNumRejectedTasks());
    assertEquals(3,tsWrapper.ts.instanceToNodeMap.size());
    assertEquals(3,tsWrapper.ts.disabledNodesQueue.size());
    TezTaskAttemptID task4=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie4=new Object();
    TezTaskAttemptID task5=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie5=new Object();
    TezTaskAttemptID task6=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie6=new Object();
    tsWrapper.allocateTask(task4,hosts1,priority1,clientCookie4);
    tsWrapper.allocateTask(task5,hosts2,priority1,clientCookie5);
    tsWrapper.allocateTask(task6,hosts3,priority1,clientCookie6);
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun();
      if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 6) {
        break;
      }
    }
    ArgumentCaptor<Container> argumentCaptor=ArgumentCaptor.forClass(Container.class);
    verify(tsWrapper.mockAppCallback,times(3)).taskAllocated(any(Object.class),any(Object.class),argumentCaptor.capture());
    assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
    assertEquals(6,tsWrapper.ts.dagStats.getNumTotalAllocations());
  }
  finally {
    tsWrapper.shutdown();
  }
}
