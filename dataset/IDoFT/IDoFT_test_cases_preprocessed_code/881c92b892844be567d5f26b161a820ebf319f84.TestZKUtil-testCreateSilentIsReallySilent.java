/** 
 * A test for HBASE-3238
 * @throws IOException A connection attempt to zk failed
 * @throws InterruptedException One of the non ZKUtil actions was interrupted
 * @throws KeeperException Any of the zookeeper connections had a KeeperException
 */
@Test public void testCreateSilentIsReallySilent() throws InterruptedException, KeeperException, IOException {
Configuration c=UTIL.getConfiguration();//RW
ZKUtil.createAndFailSilent(ZKW,aclZnode);//RW
}