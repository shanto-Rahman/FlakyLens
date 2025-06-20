/** 
 * HBASE-861 get with timestamp will return a value if there is a version with an earlier timestamp
 */
@Test public void testJiraTest861() throws Exception {
byte[][] VALUES=makeNAscii(VALUE,7);//RW
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[1]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[5]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[1]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[5]);//RW
put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[6],VALUES[6]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[0],VALUES[0]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[1]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[5]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[6],VALUES[6]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[0],VALUES[0]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[1]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[5]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[6],VALUES[6]);//RW
}