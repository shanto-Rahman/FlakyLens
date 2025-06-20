/** 
 * A test for HBASE-3238
 * @throws IOException A connection attempt to zk failed
 * @throws InterruptedException One of the non ZKUtil actions was interrupted
 * @throws KeeperException Any of the zookeeper connections had a KeeperException
 */
@Test public void testCreateSilentIsReallySilent() throws InterruptedException, KeeperException, IOException {
  Configuration c=UTIL.getConfiguration();
  String aclZnode="/aclRoot";
  String quorumServers=ZKConfig.getZKQuorumServersString(c);
  int sessionTimeout=5 * 1000;
  ZooKeeper zk=new ZooKeeper(quorumServers,sessionTimeout,EmptyWatcher.instance);
  zk.addAuthInfo("digest",Bytes.toBytes("hbase:rox"));
  Stat s;
  List<ACL> oldACL;
  while (true) {
    try {
      s=new Stat();
      oldACL=zk.getACL("/",s);
      break;
    }
 catch (    KeeperException e) {
switch (e.code()) {
case CONNECTIONLOSS:case SESSIONEXPIRED:case OPERATIONTIMEOUT:        LOG.warn("Possibly transient ZooKeeper exception",e);
      Threads.sleep(100);
    break;
default:  throw e;
}
}
}
while (true) {
try {
zk.setACL("/",ZooDefs.Ids.CREATOR_ALL_ACL,-1);
break;
}
 catch (KeeperException e) {
switch (e.code()) {
case CONNECTIONLOSS:case SESSIONEXPIRED:case OPERATIONTIMEOUT:LOG.warn("Possibly transient ZooKeeper exception: " + e);
Threads.sleep(100);
break;
default:throw e;
}
}
}
while (true) {
try {
zk.create(aclZnode,null,ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
break;
}
 catch (KeeperException e) {
switch (e.code()) {
case CONNECTIONLOSS:case SESSIONEXPIRED:case OPERATIONTIMEOUT:LOG.warn("Possibly transient ZooKeeper exception: " + e);
Threads.sleep(100);
break;
default:throw e;
}
}
}
zk.close();
ZKUtil.createAndFailSilent(ZKW,aclZnode);
ZooKeeper zk3=new ZooKeeper(quorumServers,sessionTimeout,EmptyWatcher.instance);
zk3.addAuthInfo("digest",Bytes.toBytes("hbase:rox"));
try {
zk3.setACL("/",oldACL,-1);
}
  finally {
zk3.close();
}
}
