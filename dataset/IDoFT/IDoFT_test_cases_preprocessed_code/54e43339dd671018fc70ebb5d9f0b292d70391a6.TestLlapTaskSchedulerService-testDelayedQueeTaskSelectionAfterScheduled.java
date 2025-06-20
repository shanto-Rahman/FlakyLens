@Test(timeout=10000) public void testDelayedQueeTaskSelectionAfterScheduled() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
assertEquals(2,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_NOT_RUN,delayedTaskSchedulerCallableControlled.lastState);
delayedTaskSchedulerCallableControlled.triggerGetNextTask();//IT
delayedTaskSchedulerCallableControlled.awaitGetNextTaskProcessing();//IT
assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_TIMEOUT_NOT_EXPIRED,delayedTaskSchedulerCallableControlled.lastState);
assertFalse(delayedTaskSchedulerCallableControlled.shouldScheduleTaskTriggered);
tsWrapper.awaitLocalTaskAllocations(3);//IT
assertEquals(1,argumentCaptor.getAllValues().size());
assertEquals(task3,argumentCaptor.getAllValues().get(0));
assertEquals(HOST1,assignedContainer.getNodeId().getHost());
delayedTaskSchedulerCallableControlled.triggerGetNextTask();//IT
delayedTaskSchedulerCallableControlled.awaitGetNextTaskProcessing();//IT
assertEquals(LlapTaskSchedulerServiceForTestControlled.DelayedTaskSchedulerCallableControlled.STATE_RETURNED_TASK,delayedTaskSchedulerCallableControlled.lastState);
assertTrue(delayedTaskSchedulerCallableControlled.shouldScheduleTaskTriggered && !delayedTaskSchedulerCallableControlled.lastShouldScheduleTaskResult);
tsWrapper.shutdown();//IT
}