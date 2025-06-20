@Test public void testSuperSimple() throws Exception {
HTable ht=TEST_UTIL.createTable(TABLE,FAMILY);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,VALUE);//RW
scan.addColumn(FAMILY,TABLE);//RW
assertTrue("Expected null result",result == null);
}