@Test public void testVersionLimits() throws Exception {
byte[][] FAMILIES=makeNAscii(FAMILY,3);//RW
byte[][] VALUES=makeNAscii(VALUE,10);//RW
Put put=new Put(ROW);//RW
put.add(FAMILIES[0],QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILIES[0],QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILIES[1],QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILIES[1],QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILIES[1],QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILIES[1],QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[0],VALUES[0]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[1],VALUES[1]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[2],VALUES[2]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[3],VALUES[3]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[4],VALUES[4]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[5],VALUES[5]);//RW
put.add(FAMILIES[2],QUALIFIER,STAMPS[6],VALUES[6]);//RW
Get get=new Get(ROW);//RW
get.addColumn(FAMILIES[0],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
Scan scan=new Scan(ROW);//RW
scan.addColumn(FAMILIES[0],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
get.addColumn(FAMILIES[1],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[1],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILIES[1],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILIES[1],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[1],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILIES[1],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
get.addColumn(FAMILIES[2],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[2],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILIES[2],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILIES[2],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[2],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILIES[2],QUALIFIER,new long[]//RW
get=new Get(ROW);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
get=new Get(ROW);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
get=new Get(ROW);//RW
get.addColumn(FAMILIES[0],QUALIFIER);//RW
get.addColumn(FAMILIES[1],QUALIFIER);//RW
get.addColumn(FAMILIES[2],QUALIFIER);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
scan=new Scan(ROW);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
scan=new Scan(ROW);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
scan=new Scan(ROW);//RW
scan.addColumn(FAMILIES[0],QUALIFIER);//RW
scan.addColumn(FAMILIES[1],QUALIFIER);//RW
scan.addColumn(FAMILIES[2],QUALIFIER);//RW
assertTrue("Expected 9 keys but received " + result.size(),result.size() == 9);
}