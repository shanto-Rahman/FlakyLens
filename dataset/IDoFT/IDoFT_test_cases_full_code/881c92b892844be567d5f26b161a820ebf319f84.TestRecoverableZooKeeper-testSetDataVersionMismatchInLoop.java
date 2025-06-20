@Test public void testSetDataVersionMismatchInLoop() throws Exception {
  String znode="/hbase/splitWAL/9af7cfc9b15910a0b3d714bf40a3248f";
  Configuration conf=TEST_UTIL.getConfiguration();
  ZKWatcher zkw=new ZKWatcher(conf,"testSetDataVersionMismatchInLoop",abortable,true);
  String ensemble=ZKConfig.getZKQuorumServersString(conf);
  RecoverableZooKeeper rzk=ZKUtil.connect(conf,ensemble,zkw);
  rzk.create(znode,new byte[0],Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
  rzk.setData(znode,Bytes.toBytes("OPENING"),0);
  Field zkField=RecoverableZooKeeper.class.getDeclaredField("zk");
  zkField.setAccessible(true);
  int timeout=conf.getInt(HConstants.ZK_SESSION_TIMEOUT,HConstants.DEFAULT_ZK_SESSION_TIMEOUT);
  ZookeeperStub zkStub=new ZookeeperStub(ensemble,timeout,zkw);
  zkStub.setThrowExceptionInNumOperations(1);
  zkField.set(rzk,zkStub);
  byte[] opened=Bytes.toBytes("OPENED");
  rzk.setData(znode,opened,1);
  byte[] data=rzk.getData(znode,false,new Stat());
  assertTrue(Bytes.equals(opened,data));
}
