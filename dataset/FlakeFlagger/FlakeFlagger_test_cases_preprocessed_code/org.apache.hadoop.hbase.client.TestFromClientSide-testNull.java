@Test public void testNull() throws Exception {
TEST_UTIL.createTable(null,FAMILY);//RW
fail("Creating a table with null name passed, should have failed");
fail("Creating a table with a null family passed, should fail");
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
put.add(FAMILY,QUALIFIER,VALUE);//RW
fail("Inserting a null row worked, should throw exception");
Put put=new Put(ROW);//RW
put.add(FAMILY,null,VALUE);//RW
getTestNull(ht,ROW,FAMILY,VALUE);//RW
scanTestNull(ht,ROW,FAMILY,VALUE);//RW
Delete delete=new Delete(ROW);//RW
delete.deleteColumns(FAMILY,null);//RW
Get get=new Get(ROW);//RW
ht=TEST_UTIL.createTable(TABLE2,FAMILY);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,HConstants.EMPTY_BYTE_ARRAY,VALUE);//RW
getTestNull(ht,ROW,FAMILY,VALUE);//RW
scanTestNull(ht,ROW,FAMILY,VALUE);//RW
getTestNull(ht,ROW,FAMILY,VALUE);//RW
scanTestNull(ht,ROW,FAMILY,VALUE);//RW
Delete delete=new Delete(ROW);//RW
delete.deleteColumns(FAMILY,HConstants.EMPTY_BYTE_ARRAY);//RW
Get get=new Get(ROW);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,null);//RW
Get get=new Get(ROW);//RW
get.addColumn(FAMILY,QUALIFIER);//RW
assertSingleResult(result,ROW,FAMILY,QUALIFIER,null);//RW
scan.addColumn(FAMILY,QUALIFIER);//RW
assertSingleResult(result,ROW,FAMILY,QUALIFIER,null);//RW
Delete delete=new Delete(ROW);//RW
delete.deleteColumns(FAMILY,QUALIFIER);//RW
get=new Get(ROW);//RW
}