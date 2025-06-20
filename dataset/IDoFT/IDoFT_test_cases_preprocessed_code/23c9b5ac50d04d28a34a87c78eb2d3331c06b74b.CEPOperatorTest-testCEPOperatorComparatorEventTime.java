@Test public void testCEPOperatorComparatorEventTime() throws Exception {
assertTrue(operator.hasNonEmptyPQ(42));
assertTrue(operator.hasNonEmptyPQ(43));
assertFalse(operator.hasNonEmptySharedBuffer(42));
assertFalse(operator.hasNonEmptySharedBuffer(43));
assertFalse(operator.hasNonEmptyPQ(42));
assertFalse(operator.hasNonEmptyPQ(43));
assertTrue(operator.hasNonEmptySharedBuffer(42));
assertTrue(operator.hasNonEmptySharedBuffer(43));
}