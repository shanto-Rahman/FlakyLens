@Test public void testSessionExpire() throws Exception {
  assertArrayEquals(DATA,RO_ZK.get(PATH).get());
  ZooKeeper zk=RO_ZK.zookeeper;
  long sessionId=zk.getSessionId();
  UTIL.getZkCluster().getZooKeeperServers().get(0).closeSession(sessionId);
  assertSame(zk,RO_ZK.zookeeper);
  byte[] got=RO_ZK.get(PATH).get();
  assertArrayEquals(DATA,got);
  assertNotNull(RO_ZK.zookeeper);
  assertNotSame(zk,RO_ZK.zookeeper);
  assertNotEquals(sessionId,RO_ZK.zookeeper.getSessionId());
}
