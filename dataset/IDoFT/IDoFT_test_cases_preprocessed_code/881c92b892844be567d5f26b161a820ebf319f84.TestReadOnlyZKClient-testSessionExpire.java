@Test public void testSessionExpire() throws Exception {
assertArrayEquals(DATA,RO_ZK.get(PATH).get());//RW
ZooKeeper zk=RO_ZK.zookeeper;//RW
UTIL.getZkCluster().getZooKeeperServers().get(0).closeSession(sessionId);//RW
assertSame(zk,RO_ZK.zookeeper);//RW
byte[] got=RO_ZK.get(PATH).get();//RW
assertArrayEquals(DATA,got);//RW
assertNotNull(RO_ZK.zookeeper);//RW
assertNotSame(zk,RO_ZK.zookeeper);//RW
assertNotEquals(sessionId,RO_ZK.zookeeper.getSessionId());//RW
}