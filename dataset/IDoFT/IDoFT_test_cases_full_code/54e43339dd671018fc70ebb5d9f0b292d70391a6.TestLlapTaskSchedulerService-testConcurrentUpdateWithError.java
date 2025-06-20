@Test(timeout=10000) public void testConcurrentUpdateWithError() throws IOException, InterruptedException {
  final TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority highPri=Priority.newInstance(1);
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    tsWrapper.ts.updateGuaranteedCount(0);
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,null,highPri,new Object());
    tsWrapper.awaitTotalTaskAllocations(1);
    TaskInfo ti1=tsWrapper.ts.getTaskInfo(task1);
    assertFalse(ti1.isGuaranteed());
    tsWrapper.ts.updateGuaranteedCount(1);
    tsWrapper.ts.waitForMessagesSent(1);
    assertTrue(ti1.isGuaranteed());
    assertFalse(ti1.getLastSetGuaranteed());
    assertTrue(ti1.isUpdateInProgress());
    tsWrapper.ts.updateGuaranteedCount(0);
    tsWrapper.ts.assertNoMessagesSent();
    assertFalse(ti1.isGuaranteed());
    tsWrapper.ts.handleUpdateResult(ti1,false);
    assertFalse(ti1.isGuaranteed());
    assertFalse(ti1.getLastSetGuaranteed());
    assertFalse(ti1.isUpdateInProgress());
    tsWrapper.ts.assertNoMessagesSent();
    tsWrapper.deallocateTask(task1,true,TaskAttemptEndReason.CONTAINER_EXITED);
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
  }
  finally {
    tsWrapper.shutdown();
  }
}
