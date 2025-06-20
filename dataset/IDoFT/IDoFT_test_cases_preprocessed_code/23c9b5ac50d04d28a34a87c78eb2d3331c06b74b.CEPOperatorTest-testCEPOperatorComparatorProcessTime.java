@Test public void testCEPOperatorComparatorProcessTime() throws Exception {
assertTrue(!operator.hasNonEmptySharedBuffer(42));
assertTrue(!operator.hasNonEmptySharedBuffer(43));
assertTrue(operator.hasNonEmptySharedBuffer(42));
assertTrue(operator.hasNonEmptySharedBuffer(43));
}