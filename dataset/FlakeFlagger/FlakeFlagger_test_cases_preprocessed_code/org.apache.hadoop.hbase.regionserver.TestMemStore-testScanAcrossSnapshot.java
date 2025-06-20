/** 
 * Test memstore snapshot happening while scanning.
 * @throws IOException
 */
public void testScanAcrossSnapshot() throws IOException {
assertEquals(rowCount,result.size());
assertEquals(rowCount,count);
assertTrue(Bytes.compareTo(Bytes.toBytes(count),result.get(0).getRow()) == 0);
assertEquals(rowCount,result.size());
if (count == 2) {
}
assertEquals(rowCount,count);
assertTrue(Bytes.compareTo(Bytes.toBytes(count),result.get(0).getRow()) == 0);
assertEquals("count=" + count + ", result="+ result,rowCount,result.size());
if (count == snapshotIndex) {
}
assertEquals(rowCount,count);
}