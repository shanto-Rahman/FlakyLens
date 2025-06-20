/** 
 * Test file of multiple deletes and with deletes as final key.
 * @see  <a href="https://issues.apache.org/jira/browse/HBASE-751">HBASE-751</a>
 */
public void testGetClosestRowBefore3() throws IOException {
assertTrue(Bytes.equals(T20,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T30,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T10,r.getRow()));
assertTrue(Bytes.equals(T11,r.getRow()));
if (region != null) {
}
}