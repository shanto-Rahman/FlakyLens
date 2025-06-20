@Test(timeout=10000) public void testPreemptionChoiceTimeOrdering() throws IOException, InterruptedException {
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
    tsWrapper.controlScheduler(true);
    ArgumentCaptor<Object> argumentCaptor=ArgumentCaptor.forClass(Object.class);
    ArgumentCaptor<Container> cArgCaptor=ArgumentCaptor.forClass(Container.class);
    tsWrapper.getClock().setTime(10000l);
    tsWrapper.allocateTask(task1,hostsH1,priority2,clientCookie1);
    tsWrapper.awaitLocalTaskAllocations(1);
    verify(tsWrapper.mockAppCallback,times(1)).taskAllocated(argumentCaptor.capture(),any(Object.class),cArgCaptor.capture());
    ContainerId t1Cid=cArgCaptor.getValue().getId();
    reset(tsWrapper.mockAppCallback);
    tsWrapper.getClock().setTime(tsWrapper.getClock().getTime() - 1000);
    tsWrapper.allocateTask(task2,hostsH1,priority2,clientCookie2);
    tsWrapper.awaitLocalTaskAllocations(2);
    verify(tsWrapper.mockAppCallback,times(1)).taskAllocated(argumentCaptor.capture(),any(Object.class),cArgCaptor.capture());
    reset(tsWrapper.mockAppCallback);
    tsWrapper.getClock().setTime(tsWrapper.getClock().getTime() + 2000);
    tsWrapper.allocateTask(task3,hostsH1,priority1,clientCookie3);
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun();
      if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 1) {
        break;
      }
    }
    ArgumentCaptor<ContainerId> cIdArgCaptor=ArgumentCaptor.forClass(ContainerId.class);
    verify(tsWrapper.mockAppCallback).preemptContainer(cIdArgCaptor.capture());
    assertEquals(t1Cid,cIdArgCaptor.getValue());
  }
  finally {
    tsWrapper.shutdown();
  }
}
