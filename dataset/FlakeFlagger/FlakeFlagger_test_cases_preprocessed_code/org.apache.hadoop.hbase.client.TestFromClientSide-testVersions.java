@Test public void testVersions() throws Exception {
byte[][] VALUES=makeNAscii(VALUE,20);//RW
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[3]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[6]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[3]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[6]);//RW
Get get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
Scan scan=new Scan(ROW);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[5],VALUES[5]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[3]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[6]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[3]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[6]);//RW
get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[6],VALUES[6]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[7],VALUES[7]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[8],VALUES[8]);//RW
get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
getVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[7],VALUES[7]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[1],VALUES[1]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[2],VALUES[2]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[4],VALUES[4]);//RW
scanVersionAndVerify(ht,ROW,FAMILY,QUALIFIER,STAMPS[7],VALUES[7]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
getVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[9]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[0]);//RW
scanVersionAndVerifyMissing(ht,ROW,FAMILY,QUALIFIER,STAMPS[9]);//RW
put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,STAMPS[9],VALUES[9]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[11],VALUES[11]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[13],VALUES[13]);//RW
put.add(FAMILY,QUALIFIER,STAMPS[15],VALUES[15]);//RW
get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
Delete delete=new Delete(ROW);//RW
delete.deleteColumn(FAMILY,QUALIFIER,STAMPS[11]);//RW
delete.deleteColumn(FAMILY,QUALIFIER,STAMPS[7]);//RW
get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertNResult(result,ROW,FAMILY,QUALIFIER,new long[]//RW
}