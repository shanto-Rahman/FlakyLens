@Test public void testBatchUpdateInsertAndDelOnSame() throws HectorException {
assertNotNull(found);
fail("Should not have found a value here");
assertNotNull(col);
assertEquals("testBatchMutateColumn_value_" + j,value);
}