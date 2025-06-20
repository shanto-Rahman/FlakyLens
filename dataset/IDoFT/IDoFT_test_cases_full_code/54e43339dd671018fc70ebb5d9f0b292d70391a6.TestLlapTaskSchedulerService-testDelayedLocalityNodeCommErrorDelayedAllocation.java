@Test(timeout=15000) public void testDelayedLocalityNodeCommErrorDelayedAllocation() throws IOException, InterruptedException {
  Priority priority1=Priority.newInstance(1);
  String[] hosts=new String[]{HOST1,HOST2};
  String[] hostsH1=new String[]{HOST1};
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper(5000,hosts,1,1,10000l,true);
  LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled delayedTaskSchedulerCallableControlled=(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled)tsWrapper.ts.delayedTaskSchedulerCallable;
  ControlledClock clock=tsWrapper.getClock();
  clock.setTime(clock.getTime());
  try {
    tsWrapper.controlScheduler(true);
    TezTaskAttemptID task1=tsWrapper.allocateTask(hostsH1,priority1);
    TezTaskAttemptID task2=tsWrapper.allocateTask(hostsH1,priority1);
    TezTaskAttemptID task3=tsWrapper.allocateTask(hostsH1,priority1);
    tsWrapper.awaitLocalTaskAllocations(2);
    verify(tsWrapper.mockAppCallback,never()).preemptContainer(any(ContainerId.class));
    ArgumentCaptor<Object> argumentCaptor=ArgumentCaptor.forClass(Object.class);
    verify(tsWrapper.mockAppCallback,times(2)).taskAllocated(argumentCaptor.capture(),any(Object.class),any(Container.class));
    assertEquals(2,argumentCaptor.getAllValues().size());
    assertEquals(task1,argumentCaptor.getAllValues().get(0));
    assertEquals(task2,argumentCaptor.getAllValues().get(1));
    reset(tsWrapper.mockAppCallback);
    tsWrapper.deallocateTask(task1,false,TaskAttemptEndReason.COMMUNICATION_ERROR);
    tsWrapper.ensureNoChangeInTotalAllocations(2,2000l);
  }
  finally {
    tsWrapper.shutdown();
  }
}
