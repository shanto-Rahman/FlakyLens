@Test public void testMultiFailure() throws Exception {
  String pathX=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureX");
  String pathY=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureY");
  String pathZ=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureZ");
  LinkedList<ZKUtilOp> ops=new LinkedList<>();
  ops.add(ZKUtilOp.createAndFailSilent(pathX,Bytes.toBytes(pathX)));
  ZKUtil.multiOrSequential(zkw,ops,false);
  String pathV=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureV");
  String pathW=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureW");
  ops=new LinkedList<>();
  ops.add(ZKUtilOp.createAndFailSilent(pathX,Bytes.toBytes(pathX)));
  ops.add(ZKUtilOp.setData(pathY,Bytes.toBytes(pathY)));
  ops.add(ZKUtilOp.deleteNodeFailSilent(pathZ));
  ops.add(ZKUtilOp.createAndFailSilent(pathX,Bytes.toBytes(pathV)));
  ops.add(ZKUtilOp.createAndFailSilent(pathX,Bytes.toBytes(pathW)));
  boolean caughtNodeExists=false;
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NodeExistsException nee) {
    caughtNodeExists=true;
  }
  assertTrue(caughtNodeExists);
  assertNotEquals(-1,ZKUtil.checkExists(zkw,pathX));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathY));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathZ));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathW));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathV));
  ops=new LinkedList<>();
  ops.add(ZKUtilOp.setData(pathY,Bytes.toBytes(pathY)));
  ops.add(ZKUtilOp.createAndFailSilent(pathX,Bytes.toBytes(pathX)));
  boolean caughtNoNode=false;
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NoNodeException nne) {
    caughtNoNode=true;
  }
  assertTrue(caughtNoNode);
  assertNotEquals(-1,ZKUtil.checkExists(zkw,pathX));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathY));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathZ));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathW));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathV));
}
