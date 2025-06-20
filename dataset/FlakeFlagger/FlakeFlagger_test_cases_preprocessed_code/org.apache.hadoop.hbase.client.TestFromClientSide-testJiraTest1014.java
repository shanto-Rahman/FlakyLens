/** 
 * HBASE-1014 commit(BatchUpdate) method should return timestamp
 */
@Test public void testJiraTest1014() throws Exception {
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,manualStamp,VALUE);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,manualStamp,VALUE);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,manualStamp - 1);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,manualStamp + 1);//RW
}