@Test public void testWriteScanBatchLimit() throws Exception {
Configuration hbaseConf=util.getConfiguration();//RW
assertNotNull(result);
assertTrue(!result.isEmpty());
assertTrue(result.rawCells().length <= batchLimit);
assertTrue(values.size() <= batchLimit);
assertNotNull(result);
assertTrue(!result.isEmpty());
assertTrue(result.rawCells().length <= batchLimit);
assertTrue(values.size() <= batchLimit);
assertNotNull(result);
assertTrue(!result.isEmpty());
assertTrue(result.rawCells().length <= batchLimit);
assertTrue(values.size() <= batchLimit);
assertEquals(4,values.size());
assertEquals(3,rowCount);
assertNotNull(result);
assertTrue(!result.isEmpty());
assertEquals(4,result.rawCells().length);
assertEquals(4,values.size());
assertEquals(3,rowCount);
}