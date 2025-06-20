@Test public void testGet_EmptyTable() throws IOException {
HTable table=TEST_UTIL.createTable(Bytes.toBytes("testGet_EmptyTable"),FAMILY);//RW
Get get=new Get(ROW);//RW
get.addFamily(FAMILY);//RW
assertTrue(r.isEmpty());
}