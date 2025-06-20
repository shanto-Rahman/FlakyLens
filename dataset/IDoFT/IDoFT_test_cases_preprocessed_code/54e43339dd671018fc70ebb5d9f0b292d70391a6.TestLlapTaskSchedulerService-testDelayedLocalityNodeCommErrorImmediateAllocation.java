@Test(timeout=15000) public void testDelayedLocalityNodeCommErrorImmediateAllocation() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
assertEquals(2,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun(2000l);//IT
tsWrapper.awaitChangeInTotalAllocations(2);//IT
assertTrue("Task not allocated in expected time window: duration=" + diff,diff < 9000l);
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