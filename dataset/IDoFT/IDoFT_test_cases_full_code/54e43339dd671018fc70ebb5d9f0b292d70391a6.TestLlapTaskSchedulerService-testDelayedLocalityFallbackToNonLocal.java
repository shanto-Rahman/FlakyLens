@Test(timeout=10000) public void testDelayedLocalityFallbackToNonLocal() throws IOException, InterruptedException {
  Priority priority1=Priority.newInstance(1);
  String[] hosts=new String[]{HOST1,HOST2};
  String[] hostsH1=new String[]{HOST1};
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper(2000,hosts,1,1,10000l,true);
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
    clock.setTime(clock.getTime() + 10000l);
    assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_NOT_RUN,delayedTaskSchedulerCallableControlled.lastState);
    delayedTaskSchedulerCallableControlled.triggerGetNextTask();
    delayedTaskSchedulerCallableControlled.awaitGetNextTaskProcessing();
    assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_RETURNED_TASK,delayedTaskSchedulerCallableControlled.lastState);
    assertTrue(delayedTaskSchedulerCallableControlled.shouldScheduleTaskTriggered && delayedTaskSchedulerCallableControlled.lastShouldScheduleTaskResult);
    tsWrapper.awaitChangeInTotalAllocations(2);
    verify(tsWrapper.mockAppCallback,never()).preemptContainer(any(ContainerId.class));
    argumentCaptor=ArgumentCaptor.forClass(Object.class);
    ArgumentCaptor<Container> containerCaptor=ArgumentCaptor.forClass(Container.class);
    verify(tsWrapper.mockAppCallback,times(1)).taskAllocated(argumentCaptor.capture(),any(Object.class),containerCaptor.capture());
    assertEquals(1,argumentCaptor.getAllValues().size());
    assertEquals(task3,argumentCaptor.getAllValues().get(0));
    Container assignedContainer=containerCaptor.getValue();
    assertEquals(HOST2,assignedContainer.getNodeId().getHost());
    assertEquals(2,tsWrapper.ts.dagStats.getNumLocalAllocations());
    assertEquals(1,tsWrapper.ts.dagStats.getNumNonLocalAllocations());
    assertEquals(1,tsWrapper.ts.dagStats.getNumDelayedAllocations());
    assertEquals(2,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST1).get());
    assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST2).get());
  }
  finally {
    tsWrapper.shutdown();
  }
}
