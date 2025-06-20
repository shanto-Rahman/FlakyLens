@Test(expected=NotWritablePropertyException.class) public void testBindNestedReadOnlyListCommaSeparated() throws Exception {
assertEquals("[bar, foo]",target.getNested().toString());
}