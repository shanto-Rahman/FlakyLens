@Test public void testCEPOperatorCleanupProcessingTime() throws Exception {
assertTrue(!operator.hasNonEmptyPQ(42));
assertTrue(!operator.hasNonEmptyPQ(43));
assertTrue(operator.hasNonEmptySharedBuffer(42));
assertTrue(operator.hasNonEmptySharedBuffer(43));
assertTrue(operator2.hasNonEmptySharedBuffer(42));
assertTrue(operator2.hasNonEmptySharedBuffer(42));
assertTrue(!operator2.hasNonEmptySharedBuffer(42));
assertEquals(0L,harness.numEventTimeTimers());
assertTrue(!operator2.hasNonEmptyPQ(42));
assertTrue(!operator2.hasNonEmptyPQ(43));
}