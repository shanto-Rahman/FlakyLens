@Test(timeout=10000) public void testSimpleNoLocalityAllocation() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitTotalTaskAllocations(1);//IT
assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsNoLocalityRequest());
tsWrapper.shutdown();//IT
}