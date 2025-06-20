/** 
 * HBASE-33 Add a HTable get/obtainScanner method that retrieves all versions of a particular column and row between two timestamps
 */
@Test public void testJiraTest33() throws Exception {
byte[][] VALUES=makeNAscii(VALUE,7);//RW
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,2);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,4,5);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,2,3);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,2);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,4,5);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,2,3);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,2);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,4,5);//RW
getVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,2,3);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,5);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,0,2);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,4,5);//RW
scanVersionRangeAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS,VALUES,2,3);//RW
}