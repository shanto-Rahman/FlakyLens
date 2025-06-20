@Test public void testMultipleZK(){
assertFalse(HConnectionManager.getClientZooKeeperWatcher(conf).getZooKeeperWrapper() == HConnectionManager.getClientZooKeeperWatcher(otherConf).getZooKeeperWrapper());
assertFalse(HConnectionManager.getConnection(conf).getZooKeeperWrapper().getQuorumServers().equals(HConnectionManager.getConnection(otherConf).getZooKeeperWrapper().getQuorumServers()));
fail();
}