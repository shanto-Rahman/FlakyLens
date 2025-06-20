/** 
 * Tests that we can write out an edit, close, and then read it back in again.
 * @throws IOException
 */
public void testEditAdd() throws IOException {
if (entry == null) break;
assertTrue(Bytes.equals(regionName,key.getRegionName()));
assertTrue(Bytes.equals(tableName,key.getTablename()));
assertTrue(Bytes.equals(row,kv.getRow()));
assertEquals((byte)(i + '0'),kv.getValue()[0]);
assertTrue(Bytes.equals(regionName,key.getRegionName()));
assertTrue(Bytes.equals(tableName,key.getTablename()));
assertTrue(Bytes.equals(HLog.METAROW,kv.getRow()));
assertTrue(Bytes.equals(HLog.METAFAMILY,kv.getFamily()));
assertEquals(0,Bytes.compareTo(HLog.COMPLETE_CACHE_FLUSH,val.getKeyValues().get(0).getValue()));
if (log != null) {
}
if (reader != null) {
}
}