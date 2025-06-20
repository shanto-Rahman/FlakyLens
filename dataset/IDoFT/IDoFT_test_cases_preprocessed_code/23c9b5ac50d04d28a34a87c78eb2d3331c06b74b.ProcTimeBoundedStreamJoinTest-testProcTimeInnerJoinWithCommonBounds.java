/** 
 * a.proctime >= b.proctime - 10 and a.proctime <= b.proctime + 20. 
 */
@Test public void testProcTimeInnerJoinWithCommonBounds() throws Exception {
assertEquals(1,testHarness.numProcessingTimeTimers());
assertEquals(2,testHarness.numProcessingTimeTimers());
assertEquals(4,testHarness.numKeyedStateEntries());
assertEquals(2,testHarness.numProcessingTimeTimers());
assertEquals(8,testHarness.numKeyedStateEntries());
assertEquals(4,testHarness.numProcessingTimeTimers());
assertEquals(4,testHarness.numKeyedStateEntries());
assertEquals(2,testHarness.numProcessingTimeTimers());
}