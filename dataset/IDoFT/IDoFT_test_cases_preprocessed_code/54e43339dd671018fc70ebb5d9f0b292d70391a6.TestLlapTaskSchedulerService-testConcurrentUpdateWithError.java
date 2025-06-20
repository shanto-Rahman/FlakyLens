@Test(timeout=10000) public void testConcurrentUpdateWithError() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitTotalTaskAllocations(1);//IT
assertFalse(ti1.isGuaranteed());
tsWrapper.ts.waitForMessagesSent(1);//IT
assertTrue(ti1.isGuaranteed());
assertFalse(ti1.getLastSetGuaranteed());
assertTrue(ti1.isUpdateInProgress());
tsWrapper.ts.assertNoMessagesSent();//IT
assertFalse(ti1.isGuaranteed());
assertFalse(ti1.isGuaranteed());
assertFalse(ti1.getLastSetGuaranteed());
assertFalse(ti1.isUpdateInProgress());
tsWrapper.ts.assertNoMessagesSent();//IT
assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
tsWrapper.shutdown();//IT
}