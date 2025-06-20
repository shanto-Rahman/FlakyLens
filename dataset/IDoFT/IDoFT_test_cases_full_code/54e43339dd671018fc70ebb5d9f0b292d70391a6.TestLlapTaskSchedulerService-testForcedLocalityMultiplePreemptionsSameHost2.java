@Test(timeout=10000) public void testForcedLocalityMultiplePreemptionsSameHost2() throws IOException, InterruptedException {
  Priority priority1=Priority.newInstance(1);
  Priority priority2=Priority.newInstance(2);
  String[] hosts=new String[]{HOST1,HOST2};
  String[] hostsH1=new String[]{HOST1};
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper(2000,hosts,1,1,-1l);
  try {
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1="cookie1";
    TezTaskAttemptID task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie2="cookie2";
    TezTaskAttemptID task3=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie3="cookie3";
    TezTaskAttemptID task4=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie4="cookie4";
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,hostsH1,priority2,clientCookie1);
    tsWrapper.allocateTask(task2,hostsH1,priority2,clientCookie2);
    tsWrapper.awaitLocalTaskAllocations(2);
    verify(tsWrapper.mockAppCallback,never()).preemptContainer(any(ContainerId.class));
    ArgumentCaptor<Object> argumentCaptor=ArgumentCaptor.forClass(Object.class);
    ArgumentCaptor<Container> cArgCaptor=ArgumentCaptor.forClass(Container.class);
    verify(tsWrapper.mockAppCallback,times(2)).taskAllocated(argumentCaptor.capture(),any(Object.class),cArgCaptor.capture());
    assertEquals(2,argumentCaptor.getAllValues().size());
    assertEquals(task1,argumentCaptor.getAllValues().get(0));
    assertEquals(task2,argumentCaptor.getAllValues().get(1));
    assertEquals(2,cArgCaptor.getAllValues().size());
    ContainerId t1CId=cArgCaptor.getAllValues().get(0).getId();
    reset(tsWrapper.mockAppCallback);
    tsWrapper.allocateTask(task3,hostsH1,priority1,clientCookie3);
    tsWrapper.allocateTask(task4,hostsH1,priority1,clientCookie4);
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun();
      if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 1) {
        break;
      }
    }
    ArgumentCaptor<ContainerId> cIdArgCaptor=ArgumentCaptor.forClass(ContainerId.class);
    verify(tsWrapper.mockAppCallback).preemptContainer(cIdArgCaptor.capture());
    Object deallocatedTask1;
    Object deallocatedTask2;
    if (cIdArgCaptor.getValue().equals(t1CId)) {
      deallocatedTask1=task1;
      deallocatedTask2=task2;
    }
 else {
      deallocatedTask1=task2;
      deallocatedTask2=task1;
    }
    tsWrapper.deallocateTask(deallocatedTask1,false,TaskAttemptEndReason.INTERNAL_PREEMPTION);
    tsWrapper.awaitLocalTaskAllocations(3);
    verify(tsWrapper.mockAppCallback,times(1)).taskAllocated(eq(task3),eq(clientCookie3),any(Container.class));
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun(1000l);
      if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 2) {
        break;
      }
    }
    verify(tsWrapper.mockAppCallback,times(2)).preemptContainer(any(ContainerId.class));
    tsWrapper.deallocateTask(deallocatedTask2,false,TaskAttemptEndReason.INTERNAL_PREEMPTION);
    tsWrapper.awaitLocalTaskAllocations(4);
    verify(tsWrapper.mockAppCallback,times(1)).taskAllocated(eq(task4),eq(clientCookie4),any(Container.class));
  }
  finally {
    tsWrapper.shutdown();
  }
}
