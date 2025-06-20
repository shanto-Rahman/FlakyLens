@Test public void testCloseTablePool() throws IOException {
HTablePool pool=new HTablePool(TEST_UTIL.getConfiguration(),4);//RW
HBaseAdmin admin=new HBaseAdmin(TEST_UTIL.getConfiguration());//RW
if (admin.tableExists(tableName)) {
}
Assert.assertEquals(4,pool.getCurrentPoolSize(tableName));
Assert.assertEquals(0,pool.getCurrentPoolSize(tableName));
}