@Test public void testCleanZNode() throws Exception {
  ZKWatcher zkw=new ZKWatcher(TEST_UTIL.getConfiguration(),"testNodeTracker",new TestZKNodeTracker.StubAbortable());
  final ServerName sn=ServerName.valueOf("127.0.0.1:52",45L);
  ZKUtil.createAndFailSilent(zkw,TEST_UTIL.getConfiguration().get(HConstants.ZOOKEEPER_ZNODE_PARENT,HConstants.DEFAULT_ZOOKEEPER_ZNODE_PARENT));
  final String nodeName=zkw.getZNodePaths().masterAddressZNode;
  ZKUtil.createAndFailSilent(zkw,nodeName);
  MasterAddressTracker.deleteIfEquals(zkw,sn.toString());
  assertNotNull(ZKUtil.getData(zkw,nodeName));
  ZKUtil.setData(zkw,nodeName,MasterAddressTracker.toByteArray(sn,0));
  MasterAddressTracker.deleteIfEquals(zkw,ServerName.valueOf("127.0.0.2:52",45L).toString());
  assertNotNull(ZKUtil.getData(zkw,nodeName));
  ZKUtil.setData(zkw,nodeName,MasterAddressTracker.toByteArray(sn,0));
  MasterAddressTracker.deleteIfEquals(zkw,sn.toString());
  assertNull(ZKUtil.getData(zkw,nodeName));
  MasterAddressTracker.deleteIfEquals(zkw,sn.toString());
}
