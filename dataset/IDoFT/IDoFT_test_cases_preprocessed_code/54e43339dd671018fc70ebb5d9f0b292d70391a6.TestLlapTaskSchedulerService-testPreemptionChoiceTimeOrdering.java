@Test(timeout=10000) public void testPreemptionChoiceTimeOrdering() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(1);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun();//IT
if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 1) {
}
assertEquals(t1Cid,cIdArgCaptor.getValue());
tsWrapper.shutdown();//IT
}