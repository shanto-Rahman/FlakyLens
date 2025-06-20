/** 
 * Test basic stop row filter works.
 * @throws Exception
 */
public void testStopRow() throws Exception {
assertEquals(0,count);
if (first) {
assertTrue(Bytes.BYTES_COMPARATOR.compare(startrow,kv.getRow()) == 0);
}
assertTrue(Bytes.BYTES_COMPARATOR.compare(stoprow,kv.getRow()) > 0);
assertTrue(count > 10);
}