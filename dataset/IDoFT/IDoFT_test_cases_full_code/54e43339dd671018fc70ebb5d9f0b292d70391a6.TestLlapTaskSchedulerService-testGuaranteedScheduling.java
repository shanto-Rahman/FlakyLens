@Test(timeout=10000) public void testGuaranteedScheduling() throws IOException, InterruptedException {
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority priority=Priority.newInstance(1);
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId(), task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    Object clientCookie1=new Object(), clientCookie2=new Object();
    tsWrapper.ts.updateGuaranteedCount(1);
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,null,priority,clientCookie1);
    tsWrapper.awaitTotalTaskAllocations(1);
    TaskInfo ti=tsWrapper.ts.getTaskInfo(task1);
    assertTrue(ti.isGuaranteed());
    assertEquals(State.ASSIGNED,ti.getState());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.allocateTask(task2,null,priority,clientCookie2);
    tsWrapper.awaitTotalTaskAllocations(2);
    TaskInfo ti2=tsWrapper.ts.getTaskInfo(task2);
    assertFalse(ti2.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.deallocateTask(task1,true,TaskAttemptEndReason.CONTAINER_EXITED);
    assertTrue(ti2.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.deallocateTask(task2,true,TaskAttemptEndReason.CONTAINER_EXITED);
    assertEquals(1,tsWrapper.ts.getUnusedGuaranteedCount());
  }
  finally {
    tsWrapper.shutdown();
  }
}
