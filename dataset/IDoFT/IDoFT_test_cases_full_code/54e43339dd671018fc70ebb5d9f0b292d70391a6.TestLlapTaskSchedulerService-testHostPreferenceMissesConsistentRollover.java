@Test(timeout=10000) public void testHostPreferenceMissesConsistentRollover() throws IOException, InterruptedException {
  Priority priority1=Priority.newInstance(1);
  String[] hostsKnown=new String[]{HOST1,HOST2,HOST3};
  String[] hostsLive=new String[]{HOST1,HOST2,HOST3};
  String[] hostsH2=new String[]{HOST2};
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper(2000,hostsKnown,1,0,0l,false,hostsLive,true);
  try {
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1="cookie1";
    TezTaskAttemptID task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie2="cookie2";
    TezTaskAttemptID task3=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie3="cookie3";
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,hostsH2,priority1,clientCookie1);
    tsWrapper.allocateTask(task2,hostsH2,priority1,clientCookie2);
    tsWrapper.allocateTask(task3,hostsH2,priority1,clientCookie3);
    while (true) {
      tsWrapper.signalSchedulerRun();
      tsWrapper.awaitSchedulerRun();
      if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 3) {
        break;
      }
    }
    ArgumentCaptor<Object> argumentCaptor=ArgumentCaptor.forClass(Object.class);
    ArgumentCaptor<Container> argumentCaptor2=ArgumentCaptor.forClass(Container.class);
    verify(tsWrapper.mockAppCallback,times(3)).taskAllocated(argumentCaptor.capture(),any(Object.class),argumentCaptor2.capture());
    assertEquals(3,argumentCaptor.getAllValues().size());
    assertEquals(task1,argumentCaptor.getAllValues().get(0));
    assertEquals(task2,argumentCaptor.getAllValues().get(1));
    assertEquals(task3,argumentCaptor.getAllValues().get(2));
    assertEquals(HOST2,argumentCaptor2.getAllValues().get(0).getNodeId().getHost());
    assertEquals(HOST3,argumentCaptor2.getAllValues().get(1).getNodeId().getHost());
    assertEquals(HOST1,argumentCaptor2.getAllValues().get(2).getNodeId().getHost());
    verify(tsWrapper.mockServiceInstanceSet,atLeast(2)).getAllInstancesOrdered(true);
    assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
    assertEquals(1,tsWrapper.ts.dagStats.getNumLocalAllocations());
    assertEquals(2,tsWrapper.ts.dagStats.getNumNonLocalAllocations());
  }
  finally {
    tsWrapper.shutdown();
  }
}
