@Test public void testRunSequentialOnMultiFailure() throws Exception {
String path1=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential1");//RW
String path2=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential2");//RW
String path3=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential3");//RW
String path4=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential4");//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
ZKUtil.multiOrSequential(zkw,ops,true);//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path1),Bytes.add(Bytes.toBytes(path1),Bytes.toBytes(path1))));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,path2));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,path3));//RW
assertNotEquals(-1,ZKUtil.checkExists(zkw,path4));//RW
}