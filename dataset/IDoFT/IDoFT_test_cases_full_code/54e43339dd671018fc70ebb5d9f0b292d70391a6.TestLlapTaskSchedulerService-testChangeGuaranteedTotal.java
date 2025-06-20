@Test(timeout=10000) public void testChangeGuaranteedTotal() throws IOException, InterruptedException {
  TestTaskSchedulerServiceWrapper tsWrapper=new TestTaskSchedulerServiceWrapper();
  try {
    Priority highPri=Priority.newInstance(1), lowPri=Priority.newInstance(2);
    TezTaskAttemptID task1=TestTaskSchedulerServiceWrapper.generateTaskAttemptId(), task2=TestTaskSchedulerServiceWrapper.generateTaskAttemptId(), task3=TestTaskSchedulerServiceWrapper.generateTaskAttemptId();
    tsWrapper.ts.updateGuaranteedCount(0);
    tsWrapper.controlScheduler(true);
    tsWrapper.allocateTask(task1,null,highPri,new Object());
    tsWrapper.allocateTask(task2,null,lowPri,new Object());
    tsWrapper.allocateTask(task3,null,lowPri,new Object());
    tsWrapper.awaitTotalTaskAllocations(3);
    TaskInfo ti1=tsWrapper.ts.getTaskInfo(task1), ti2=tsWrapper.ts.getTaskInfo(task2), ti3=tsWrapper.ts.getTaskInfo(task3);
    assertFalse(ti1.isGuaranteed() || ti2.isGuaranteed() || ti3.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(2);
    assertTrue(ti1.isGuaranteed());
    TaskInfo ti23High=ti2.isGuaranteed() ? ti2 : ti3, ti23Low=(ti2 == ti23High) ? ti3 : ti2;
    assertTrue(ti23High.isGuaranteed());
    assertFalse(ti23Low.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(4);
    assertTrue(ti1.isGuaranteed());
    assertTrue(ti23High.isGuaranteed());
    assertTrue(ti23Low.isGuaranteed());
    assertEquals(1,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(6);
    assertTrue(ti1.isGuaranteed());
    assertTrue(ti23High.isGuaranteed());
    assertTrue(ti23Low.isGuaranteed());
    assertEquals(3,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(5);
    assertTrue(ti1.isGuaranteed());
    assertTrue(ti23High.isGuaranteed());
    assertTrue(ti23Low.isGuaranteed());
    assertEquals(2,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(1);
    assertTrue(ti1.isGuaranteed());
    assertFalse(ti23High.isGuaranteed());
    assertFalse(ti23Low.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.ts.updateGuaranteedCount(0);
    assertFalse(ti1.isGuaranteed());
    assertFalse(ti23High.isGuaranteed());
    assertFalse(ti23Low.isGuaranteed());
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
    tsWrapper.deallocateTask(task1,true,TaskAttemptEndReason.CONTAINER_EXITED);
    tsWrapper.deallocateTask(task2,true,TaskAttemptEndReason.CONTAINER_EXITED);
    tsWrapper.deallocateTask(task3,true,TaskAttemptEndReason.CONTAINER_EXITED);
    assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
  }
  finally {
    tsWrapper.shutdown();
  }
}
