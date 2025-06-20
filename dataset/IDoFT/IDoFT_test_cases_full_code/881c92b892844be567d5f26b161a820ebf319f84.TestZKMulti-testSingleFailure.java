@Test public void testSingleFailure() throws Exception {
  boolean caughtNoNode=false;
  String path=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureZ");
  LinkedList<ZKUtilOp> ops=new LinkedList<>();
  ops.add(ZKUtilOp.deleteNodeFailSilent(path));
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NoNodeException nne) {
    caughtNoNode=true;
  }
  assertTrue(caughtNoNode);
  caughtNoNode=false;
  ops=new LinkedList<>();
  ops.add(ZKUtilOp.setData(path,Bytes.toBytes(path)));
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NoNodeException nne) {
    caughtNoNode=true;
  }
  assertTrue(caughtNoNode);
  boolean caughtNodeExists=false;
  ops=new LinkedList<>();
  ops.add(ZKUtilOp.createAndFailSilent(path,Bytes.toBytes(path)));
  ZKUtil.multiOrSequential(zkw,ops,false);
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NodeExistsException nee) {
    caughtNodeExists=true;
  }
  assertTrue(caughtNodeExists);
}
