@Test(timeout=15000) public void testDelayedLocalityNodeCommErrorDelayedAllocation() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(2);//IT
assertEquals(2,argumentCaptor.getAllValues().size());
assertEquals(task1,argumentCaptor.getAllValues().get(0));
assertEquals(task2,argumentCaptor.getAllValues().get(1));
tsWrapper.ensureNoChangeInTotalAllocations(2,2000l);//IT
tsWrapper.shutdown();//IT
}