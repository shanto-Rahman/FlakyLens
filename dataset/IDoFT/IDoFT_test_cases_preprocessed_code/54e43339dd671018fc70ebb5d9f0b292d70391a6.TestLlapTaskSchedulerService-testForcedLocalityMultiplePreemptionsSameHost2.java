@Test(timeout=10000) public void testForcedLocalityMultiplePreemptionsSameHost2() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
assertEquals(2,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
assertEquals(2,cArgCaptor.getAllValues().size());
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun();//IT
if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 1) {
}
if (cIdArgCaptor.getValue().equals(t1CId)) {
}
tsWrapper.awaitLocalTaskAllocations(3);//IT
tsWrapper.signalSchedulerRun();//IT
tsWrapper.awaitSchedulerRun(1000l);//IT
if (tsWrapper.ts.dagStats.getNumPreemptedTasks() == 2) {
}
tsWrapper.awaitLocalTaskAllocations(4);//IT
tsWrapper.shutdown();//IT
}