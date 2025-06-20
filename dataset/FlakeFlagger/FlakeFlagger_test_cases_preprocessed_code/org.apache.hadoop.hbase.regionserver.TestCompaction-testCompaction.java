/** 
 * Run compaction and flushing memstore Assert deletes get cleaned up.
 * @throws Exception
 */
public void testCompaction() throws Exception {
assertEquals(COMPACTION_THRESHOLD,result.size());
assertTrue(this.cluster.getFileSystem().exists(this.compactionDir));
assertTrue(!this.cluster.getFileSystem().exists(this.regionCompactionDir));
assertEquals(3,result.size());
assertTrue(result.isEmpty());
assertTrue(result.isEmpty());
assertTrue(result.isEmpty());
assertEquals(r.getStore(COLUMN_FAMILY_TEXT).getStorefiles().size(),1);
assertTrue(result.isEmpty());
if (Bytes.equals(row,STARTROW)) {
assertFalse(Bytes.equals(row,secondRowBytes));
}
assertTrue(containsStartRow);
assertTrue(count == 3);
Thread.sleep(ttlInSeconds * 1000);
assertTrue(count == 0);
}