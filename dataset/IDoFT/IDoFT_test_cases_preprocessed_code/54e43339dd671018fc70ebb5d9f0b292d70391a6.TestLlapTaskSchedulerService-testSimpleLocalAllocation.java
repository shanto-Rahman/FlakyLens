@Test(timeout=10000) public void testSimpleLocalAllocation() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitLocalTaskAllocations(1);//IT
assertEquals(1,tsWrapper.ts.dagStats.getNumLocalAllocations());
assertEquals(1,tsWrapper.ts.dagStats.getNumAllocationsPerHost().get(HOST1).get());
tsWrapper.shutdown();//IT
}