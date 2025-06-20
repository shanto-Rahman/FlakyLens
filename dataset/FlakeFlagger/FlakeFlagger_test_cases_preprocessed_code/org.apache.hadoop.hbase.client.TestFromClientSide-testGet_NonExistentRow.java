@Test public void testGet_NonExistentRow() throws IOException {
HTable table=TEST_UTIL.createTable(Bytes.toBytes("testGet_NonExistentRow"),FAMILY);//RW
Put put=new Put(ROW);//RW
put.add(FAMILY,QUALIFIER,VALUE);//RW
Get get=new Get(ROW);//RW
get.addFamily(FAMILY);//RW
assertFalse(r.isEmpty());
get.addFamily(FAMILY);//RW
assertTrue(r.isEmpty());
}