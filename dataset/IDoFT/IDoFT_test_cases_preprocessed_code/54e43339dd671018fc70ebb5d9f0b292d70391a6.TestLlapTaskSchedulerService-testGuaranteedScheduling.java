@Test(timeout=10000) public void testGuaranteedScheduling() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitTotalTaskAllocations(1);//IT
assertTrue(ti.isGuaranteed());
assertEquals(State.ASSIGNED,ti.getState());
assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
tsWrapper.awaitTotalTaskAllocations(2);//IT
assertFalse(ti2.isGuaranteed());
assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
assertTrue(ti2.isGuaranteed());
assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
assertEquals(1,tsWrapper.ts.getUnusedGuaranteedCount());
tsWrapper.shutdown();//IT
}