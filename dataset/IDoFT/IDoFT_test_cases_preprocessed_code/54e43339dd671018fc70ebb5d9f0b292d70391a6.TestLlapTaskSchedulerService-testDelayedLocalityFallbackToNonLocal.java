@Test(timeout=10000) public void testDelayedLocalityFallbackToNonLocal() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
assertEquals(2,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_NOT_RUN,delayedTaskSchedulerCallableControlled.lastState);
delayedTaskSchedulerCallableControlled.triggerGetNextTask();//IT
delayedTaskSchedulerCallableControlled.awaitGetNextTaskProcessing();//IT
assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_RETURNED_TASK,delayedTaskSchedulerCallableControlled.lastState);
assertTrue(delayedTaskSchedulerCallableControlled.shouldScheduleTaskTriggered && delayedTaskSchedulerCallableControlled.lastShouldScheduleTaskResult);
tsWrapper.awaitChangeInTotalAllocations(2);//IT
assertEquals(1,argumentCaptor.getAllValues().size());
assertEquals(task3,argumentCaptor.getAllValues().get(0));
assertEquals(HOST2,assignedContainer.getNodeId().getHost());
assertEquals(2,tsWrapper.ts.dagStats.getNumLocalAllocations());
assertEquals(1,tsWrapper.ts.dagStats.getNumNonLocalAllocations());
assertEquals(1,tsWrapper.ts.dagStats.getNumDelayedAllocations());
assertEquals(2,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST1).get());
assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST2).get());
tsWrapper.shutdown();//IT
}