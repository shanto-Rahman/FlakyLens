@Test public void testBindDoubleNestedReadOnlyListIndexed() throws Exception {
assertEquals("[bar, foo]",target.getBean().getNested().toString());
}