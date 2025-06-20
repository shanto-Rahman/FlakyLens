/** 
 * a.rowtime >= b.rowtime - 10 and a.rowtime <= b.rowtime + 20. 
 */
@Test public void testRowTimeInnerJoinWithCommonBounds() throws Exception {
assertEquals(1,testHarness.numEventTimeTimers());
assertEquals(2,testHarness.numEventTimeTimers());
assertEquals(4,testHarness.numKeyedStateEntries());
assertEquals(4,testHarness.numKeyedStateEntries());
assertEquals(6,testHarness.numKeyedStateEntries());
assertEquals(4,testHarness.numKeyedStateEntries());
}