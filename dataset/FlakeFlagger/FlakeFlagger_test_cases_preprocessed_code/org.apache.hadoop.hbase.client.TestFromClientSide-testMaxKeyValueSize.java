@Test public void testMaxKeyValueSize() throws Exception {
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,value);//RW
ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,value);//RW
fail("Inserting a too large KeyValue worked, should throw exception");
}