@Test public void testSingleFailureInMulti() throws Exception {
String pathA=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiA");//RW
String pathB=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiB");//RW
String pathC=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureInMultiC");//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNoNode);
assertEquals(-1,ZKUtil.checkExists(zkw,pathA));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathB));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathC));//RW
}