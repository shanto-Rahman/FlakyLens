@Test public void testMultiFailure() throws Exception {
String pathX=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureX");//RW
String pathY=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureY");//RW
String pathZ=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureZ");//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
String pathV=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureV");//RW
String pathW=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testMultiFailureW");//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNodeExists);
assertNotEquals(-1,ZKUtil.checkExists(zkw,pathX));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathY));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathZ));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathW));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathV));//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNoNode);
assertNotEquals(-1,ZKUtil.checkExists(zkw,pathX));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathY));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathZ));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathW));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,pathV));//RW
}