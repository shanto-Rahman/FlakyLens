@Test(timeout=10000) public void testHostPreferenceMissesConsistentRollover() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun();//IT
if (tsWrapper.ts.dagStats.getNumTotalAllocations() == 3) {
}
assertEquals(3,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
assertEquals(task3,argumentCaptor.getAllValues().get(2));
assertEquals(HOST2,argumentCaptor2.getAllValues().get(0).getNodeId().getHost());
assertEquals(HOST3,argumentCaptor2.getAllValues().get(1).getNodeId().getHost());
assertEquals(HOST1,argumentCaptor2.getAllValues().get(2).getNodeId().getHost());
assertEquals(0,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
assertEquals(1,tsWrapper.ts.dagStats.getNumLocalAllocations());
assertEquals(2,tsWrapper.ts.dagStats.getNumNonLocalAllocations());
tsWrapper.shutdown();//IT
}