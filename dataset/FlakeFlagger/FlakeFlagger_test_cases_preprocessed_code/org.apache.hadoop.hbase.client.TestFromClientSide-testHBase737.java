/** 
 * test for HBASE-737
 * @throws IOException
 */
@Test public void testHBase737() throws IOException {
Put put=new Put(ROW);//RW
Thread.sleep(1000);
put=new Put(ROW);//RW
Thread.sleep(1000);
put=new Put(ROW);//RW
assertTrue(times[j] > times[i]);
Thread.sleep(1000);
assertTrue(times[j] > times[i]);
}