@Test public void testRowTimeLeftOuterJoin() throws Exception {
assertEquals(2,testHarness.numEventTimeTimers());
assertEquals(4,testHarness.numKeyedStateEntries());
assertEquals(1,testHarness.numEventTimeTimers());
assertEquals(2,testHarness.numKeyedStateEntries());
assertEquals(0,testHarness.numEventTimeTimers());
assertEquals(0,testHarness.numKeyedStateEntries());
assertEquals(0,testHarness.numKeyedStateEntries());
assertEquals(0,testHarness.numEventTimeTimers());
}