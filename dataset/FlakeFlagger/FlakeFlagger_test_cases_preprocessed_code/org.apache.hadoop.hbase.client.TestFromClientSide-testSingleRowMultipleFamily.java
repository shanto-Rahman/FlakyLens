/** 
 * Test basic puts, gets, scans, and deletes for a single row in a multiple family table.
 */
@Test public void testSingleRowMultipleFamily() throws Exception {
byte[][] ROWS=makeN(ROW,3);//RW
byte[][] FAMILIES=makeNAscii(FAMILY,10);//RW
byte[][] QUALIFIERS=makeN(QUALIFIER,10);//RW
byte[][] VALUES=makeN(VALUE,10);//RW
}