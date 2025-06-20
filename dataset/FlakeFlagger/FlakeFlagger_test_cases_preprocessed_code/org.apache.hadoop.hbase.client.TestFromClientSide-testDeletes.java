@Test public void testDeletes() throws Exception {
byte[][] ROWS=makeNAscii(ROW,6);//RW
byte[][] FAMILIES=makeNAscii(FAMILY,3);//RW
byte[][] VALUES=makeN(VALUE,5);//RW
Put put=new Put(ROW);//RW
put.add(FAMILIES[0],QUALIFIER,ts[0],VALUES[0]);//RW
put.add(FAMILIES[0],QUALIFIER,ts[1],VALUES[1]);//RW
Delete delete=new Delete(ROW);//RW
Get get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
Scan scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
put=new Put(ROW);//RW
put.add(FAMILIES[0],QUALIFIER,ts[4],VALUES[4]);//RW
put.add(FAMILIES[0],QUALIFIER,ts[2],VALUES[2]);//RW
put.add(FAMILIES[0],QUALIFIER,ts[3],VALUES[3]);//RW
delete=new Delete(ROW);//RW
delete.deleteColumn(FAMILIES[0],QUALIFIER);//RW
get=new Get(ROW);//RW
get.addColumn(FAMILIES[0],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
scan.addColumn(FAMILIES[0],QUALIFIER);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
delete=new Delete(ROW);//RW
delete=new Delete(ROW);//RW
put=new Put(ROW);//RW
put.add(FAMILIES[0],QUALIFIER,ts[0],VALUES[0]);//RW
put.add(FAMILIES[0],QUALIFIER,ts[4],VALUES[4]);//RW
get=new Get(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
scan=new Scan(ROW);//RW
assertNResult(result,ROW,FAMILIES[0],QUALIFIER,new long[]//RW
put.add(FAMILIES[1],QUALIFIER,ts[0],VALUES[0]);//RW
put.add(FAMILIES[1],QUALIFIER,ts[1],VALUES[1]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[2],VALUES[2]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[3],VALUES[3]);//RW
put.add(FAMILIES[1],QUALIFIER,ts[0],VALUES[0]);//RW
put.add(FAMILIES[1],QUALIFIER,ts[1],VALUES[1]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[2],VALUES[2]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[3],VALUES[3]);//RW
put.add(FAMILIES[1],QUALIFIER,ts[0],VALUES[0]);//RW
put.add(FAMILIES[1],QUALIFIER,ts[1],VALUES[1]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[2],VALUES[2]);//RW
put.add(FAMILIES[2],QUALIFIER,ts[3],VALUES[3]);//RW
delete.deleteColumns(FAMILIES[1],QUALIFIER);//RW
delete.deleteColumn(FAMILIES[1],QUALIFIER);//RW
delete.deleteColumn(FAMILIES[1],QUALIFIER);//RW
delete.deleteColumn(FAMILIES[2],QUALIFIER);//RW
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertNResult(result,ROWS[0],FAMILIES[1],QUALIFIER,new long[]//RW
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertNResult(result,ROWS[0],FAMILIES[1],QUALIFIER,new long[]//RW
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertTrue("Expected 1 key but received " + result.size(),result.size() == 1);
assertNResult(result,ROWS[2],FAMILIES[2],QUALIFIER,new long[]//RW
assertTrue("Expected 1 key but received " + result.size(),result.size() == 1);
assertNResult(result,ROWS[2],FAMILIES[2],QUALIFIER,new long[]//RW
put.add(FAMILIES[2],QUALIFIER,VALUES[0]);//RW
put.add(FAMILIES[1],QUALIFIER,VALUES[1]);//RW
put.add(FAMILIES[2],QUALIFIER,VALUES[2]);//RW
assertTrue("Expected 1 key but received " + result.size(),result.size() == 1);
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertTrue("Expected 1 key but received " + result.size(),result.size() == 1);
assertTrue(Bytes.equals(result.sorted()[0].getRow(),ROWS[3]));
assertTrue(Bytes.equals(result.sorted()[0].getValue(),VALUES[0]));
assertTrue("Expected 2 keys but received " + result.size(),result.size() == 2);
assertTrue(Bytes.equals(result.sorted()[0].getRow(),ROWS[4]));
assertTrue(Bytes.equals(result.sorted()[1].getRow(),ROWS[4]));
assertTrue(Bytes.equals(result.sorted()[0].getValue(),VALUES[1]));
assertTrue(Bytes.equals(result.sorted()[1].getValue(),VALUES[2]));
put.add(FAMILIES[0],QUALIFIER,bytes);//RW
assertTrue(result.size() == 1);
assertTrue(result.size() == 0);
}