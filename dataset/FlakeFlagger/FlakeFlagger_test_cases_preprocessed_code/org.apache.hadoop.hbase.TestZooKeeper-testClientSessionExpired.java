/** 
 * See HBASE-1232 and http://wiki.apache.org/hadoop/ZooKeeper/FAQ#4.
 * @throws IOException
 * @throws InterruptedException
 */
@Test public void testClientSessionExpired() throws IOException, InterruptedException {
Thread.sleep(sessionTimeout * 3L);
}