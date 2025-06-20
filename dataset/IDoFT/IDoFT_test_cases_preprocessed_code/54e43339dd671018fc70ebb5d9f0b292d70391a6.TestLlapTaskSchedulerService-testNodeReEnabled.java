@Test(timeout=10000) public void testNodeReEnabled() throws InterruptedException, IOException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun();//IT
if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 3) {
}
assertEquals(3,tsWrapper.ts.dagStats.getNumLocalAllocations());
assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
assertEquals(3,tsWrapper.ts.dagStats.getNumTotalAllocations());
tsWrapper.resetAppCallback();//IT
tsWrapper.rejectExecution(task1);//IT
tsWrapper.rejectExecution(task2);//IT
tsWrapper.rejectExecution(task3);//IT
assertEquals(3,tsWrapper.ts.dagStats.getNumRejectedTasks());
assertEquals(3,tsWrapper.ts.instanceToNodeMap.size());
assertEquals(3,tsWrapper.ts.disabledNodesQueue.size());
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun();//IT
if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 6) {
}
assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
assertEquals(6,tsWrapper.ts.dagStats.getNumTotalAllocations());
tsWrapper.shutdown();//IT
}