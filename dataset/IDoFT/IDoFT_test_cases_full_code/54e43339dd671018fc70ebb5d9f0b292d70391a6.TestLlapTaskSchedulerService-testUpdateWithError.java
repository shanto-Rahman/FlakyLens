@Test(timeout=10000) public void testUpdateWithError() throws IOException, InterruptedException {
  final TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority highPri=Priority.newInstance(1), lowPri=Priority.newInstance(2);
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId(), task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId(), task3=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    tsWrapper.ts.updateGuaranteedCount(0);
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,null,highPri,new Object());
    tsWrapper.allocateTask(task2,null,highPri,new Object());
    tsWrapper.awaitTotalTaskAllocations(2);
    TaskInfo ti1=tsWrapper.ts.getTaskInfo(task1), ti2=tsWrapper.ts.getTaskInfo(task2);
    assertFalse(ti1.isGuaranteed() || ti2.isGuaranteed());
    tsWrapper.ts.updateGuaranteedCount(1);
    tsWrapper.ts.waitForMessagesSent(1);
    TaskInfo tiHigher=ti1.isGuaranteed() ? ti1 : ti2, tiLower=(tiHigher == ti1) ? ti2 : ti1;
    assertTrue(tiHigher.isGuaranteed());
    assertFalse(tiHigher.getLastSetGuaranteed());
    assertTrue(tiHigher.isUpdateInProgress());
    tsWrapper.ts.handleUpdateResult(tiHigher,false);
    tsWrapper.ts.waitForMessagesSent(1);
    assertFalse(tiHigher.isGuaranteed());
    assertFalse(tiHigher.getLastSetGuaranteed());
    assertFalse(tiHigher.isUpdateInProgress());
    assertTrue(tiLower.isGuaranteed());
    assertFalse(tiLower.getLastSetGuaranteed());
    assertTrue(tiLower.isUpdateInProgress());
    tsWrapper.ts.updateGuaranteedCount(0);
    tsWrapper.ts.handleUpdateResult(tiLower,false);
    tsWrapper.ts.assertNoMessagesSent();
    tsWrapper.deallocateTask(task2,true,TaskAttemptEndReason.CONTAINER_EXITED);
    tsWrapper.allocateTask(task3,null,lowPri,new Object());
    tsWrapper.awaitTotalTaskAllocations(3);
    TaskInfo ti3=tsWrapper.ts.getTaskInfo(task3);
    tsWrapper.ts.updateGuaranteedCount(1);
    tsWrapper.ts.waitForMessagesSent(1);
    assertTrue(ti1.isGuaranteed());
    assertTrue(ti1.isUpdateInProgress());
    tsWrapper.ts.handleUpdateResult(ti1,false);
    assertTrue(ti1.isGuaranteed());
    assertFalse(ti1.getLastSetGuaranteed());
    assertTrue(ti1.isUpdateInProgress());
    assertFalse(ti3.isGuaranteed());
    assertFalse(ti3.isUpdateInProgress());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
  }
  finally {
    tsWrapper.shutdown();
  }
}
