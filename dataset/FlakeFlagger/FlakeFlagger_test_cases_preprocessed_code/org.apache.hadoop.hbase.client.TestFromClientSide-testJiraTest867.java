/** 
 * HBASE-867 If millions of columns in a column family, hbase scanner won't come up Test will create numRows rows, each with numColsPerRow columns (1 version each), and attempt to scan them all. To test at scale, up numColsPerRow to the millions (have not gotten that to work running as junit though)
 */
@Test public void testJiraTest867() throws Exception {
byte[][] ROWS=makeN(ROW,numRows);//RW
byte[][] QUALIFIERS=makeN(QUALIFIER,numColsPerRow);//RW
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
put.add(FAMILY,QUALIFIERS[j],QUALIFIERS[j]);//RW
assertTrue("Put expected to contain " + numColsPerRow + " columns but "+ "only contains "+ put.size(),put.size() == numColsPerRow);
assertKey(keys[i],ROWS[numRows - 1],FAMILY,QUALIFIERS[i],QUALIFIERS[i]);//RW
assertKey(kvs[i],ROWS[rowCount],FAMILY,QUALIFIERS[i],QUALIFIERS[i]);//RW
assertTrue("Expected to scan " + numRows + " rows but actually scanned "+ rowCount+ " rows",rowCount == numRows);
assertKey(keys[i],ROWS[numRows - 1],FAMILY,QUALIFIERS[i],QUALIFIERS[i]);//RW
assertKey(kvs[i],ROWS[rowCount],FAMILY,QUALIFIERS[i],QUALIFIERS[i]);//RW
assertTrue("Expected to scan " + numRows + " rows but actually scanned "+ rowCount+ " rows",rowCount == numRows);
}