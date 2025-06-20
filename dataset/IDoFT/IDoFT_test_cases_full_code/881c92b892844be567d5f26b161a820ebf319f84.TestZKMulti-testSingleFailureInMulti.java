@Test public void testSingleFailureInMulti() throws Exception {
  String pathA=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiA");
  String pathB=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiB");
  String pathC=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiC");
  LinkedList<ZKUtilOp> ops=new LinkedList<>();
  ops.add(ZKUtilOp.createAndFailSilent(pathA,Bytes.toBytes(pathA)));
  ops.add(ZKUtilOp.createAndFailSilent(pathB,Bytes.toBytes(pathB)));
  ops.add(ZKUtilOp.deleteNodeFailSilent(pathC));
  boolean caughtNoNode=false;
  try {
    ZKUtil.multiOrSequential(zkw,ops,false);
  }
 catch (  KeeperException.NoNodeException nne) {
    caughtNoNode=true;
  }
  assertTrue(caughtNoNode);
  assertEquals(-1,ZKUtil.checkExists(zkw,pathA));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathB));
  assertEquals(-1,ZKUtil.checkExists(zkw,pathC));
}
