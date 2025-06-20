@Test public void testComplexMulti() throws Exception {
String path1=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti1");//RW
String path2=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti2");//RW
String path3=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti3");//RW
String path4=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti4");//RW
String path5=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti5");//RW
String path6=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testComplexMulti6");//RW
ZKUtil.multiOrSequential(zkw,create4Nodes,false);//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path1),Bytes.toBytes(path1)));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path2),Bytes.toBytes(path2)));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path3),Bytes.toBytes(path3)));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path4),Bytes.toBytes(path4)));//RW
ZKUtil.multiOrSequential(zkw,ops,false);//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path1),Bytes.add(Bytes.toBytes(path1),Bytes.toBytes(path1))));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path2),Bytes.add(Bytes.toBytes(path2),Bytes.toBytes(path2))));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,path3));//RW
assertEquals(-1,ZKUtil.checkExists(zkw,path4));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path5),Bytes.toBytes(path5)));//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path6),Bytes.toBytes(path6)));//RW
}