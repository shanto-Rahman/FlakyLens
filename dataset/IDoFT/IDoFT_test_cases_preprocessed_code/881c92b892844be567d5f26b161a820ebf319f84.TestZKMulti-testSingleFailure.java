@Test public void testSingleFailure() throws Exception {
String path=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSingleFailureZ");//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNoNode);
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNoNode);
ZKUtil.multiOrSequential(zkw,ops,false);//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(caughtNodeExists);
}