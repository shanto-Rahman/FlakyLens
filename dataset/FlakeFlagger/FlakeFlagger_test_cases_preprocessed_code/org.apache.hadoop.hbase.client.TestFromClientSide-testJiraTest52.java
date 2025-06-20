/** 
 * HBASE-52 Add a means of scanning over all versions
 */
@Test public void testJiraTest52() throws Exception {
byte[][] VALUES=makeNAscii(VALUE,7);//RW
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
getAllVersionsAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
scanAllVersionsAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
getAllVersionsAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
scanAllVersionsAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
}