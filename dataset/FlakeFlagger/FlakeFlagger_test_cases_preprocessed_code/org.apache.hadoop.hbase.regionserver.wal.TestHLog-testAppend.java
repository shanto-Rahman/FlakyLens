/** 
 * @throws IOException
 */
public void testAppend() throws IOException {
assertEquals(COL_COUNT,entry.getEdit().size());
assertTrue(Bytes.equals(hri.getRegionName(),entry.getKey().getRegionName()));
assertTrue(Bytes.equals(tableName,entry.getKey().getTablename()));
assertTrue(Bytes.equals(row,val.getRow()));
assertEquals((byte)(idx + '0'),val.getValue()[0]);
assertEquals(1,entry.getEdit().size());
assertTrue(Bytes.equals(hri.getRegionName(),entry.getKey().getRegionName()));
assertTrue(Bytes.equals(tableName,entry.getKey().getTablename()));
assertTrue(Bytes.equals(HLog.METAROW,val.getRow()));
assertTrue(Bytes.equals(HLog.METAFAMILY,val.getFamily()));
assertEquals(0,Bytes.compareTo(HLog.COMPLETE_CACHE_FLUSH,val.getValue()));
if (log != null) {
}
if (reader != null) {
}
}