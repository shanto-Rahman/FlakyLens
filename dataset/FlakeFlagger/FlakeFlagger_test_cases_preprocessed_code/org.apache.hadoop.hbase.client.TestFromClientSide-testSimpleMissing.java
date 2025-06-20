/** 
 * Test simple table and non-existent row cases.
 */
@Test public void testSimpleMissing() throws Exception {
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
byte[][] ROWS=makeN(ROW,4);//RW
get.addFamily(FAMILY);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
scan.addFamily(FAMILY);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
put.add(FAMILY,QUALIFIER,VALUE);//RW
get.addFamily(FAMILY);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
get.addFamily(FAMILY);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
assertSingleResult(result,ROWS[2],FAMILY,QUALIFIER,VALUE);//RW
}