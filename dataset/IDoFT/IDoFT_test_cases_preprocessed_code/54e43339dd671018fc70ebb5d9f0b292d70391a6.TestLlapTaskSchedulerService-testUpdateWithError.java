@Test(timeout=10000) public void testUpdateWithError() throws IOException, InterruptedException {
tsWrapper.controlScheduler(true);//IT
tsWrapper.awaitTotalTaskAllocations(2);//IT
assertFalse(ti1.isGuaranteed() || ti2.isGuaranteed());
tsWrapper.ts.waitForMessagesSent(1);//IT
assertTrue(tiHigher.isGuaranteed());
assertFalse(tiHigher.getLastSetGuaranteed());
assertTrue(tiHigher.isUpdateInProgress());
tsWrapper.ts.waitForMessagesSent(1);//IT
assertFalse(tiHigher.isGuaranteed());
assertFalse(tiHigher.getLastSetGuaranteed());
assertFalse(tiHigher.isUpdateInProgress());
assertTrue(tiLower.isGuaranteed());
assertFalse(tiLower.getLastSetGuaranteed());
assertTrue(tiLower.isUpdateInProgress());
tsWrapper.ts.assertNoMessagesSent();//IT
tsWrapper.awaitTotalTaskAllocations(3);//IT
tsWrapper.ts.waitForMessagesSent(1);//IT
assertTrue(ti1.isGuaranteed());
assertTrue(ti1.isUpdateInProgress());
assertTrue(ti1.isGuaranteed());
assertFalse(ti1.getLastSetGuaranteed());
assertTrue(ti1.isUpdateInProgress());
assertFalse(ti3.isGuaranteed());
assertFalse(ti3.isUpdateInProgress());
assertEquals(0,tsWrapper.ts.getUnusedGuaranteedCount());
tsWrapper.shutdown();//IT
}