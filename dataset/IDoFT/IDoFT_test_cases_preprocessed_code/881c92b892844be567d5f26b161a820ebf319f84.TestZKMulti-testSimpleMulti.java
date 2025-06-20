@Test public void testSimpleMulti() throws Exception {
ZKUtil.multiOrSequential(zkw,null,false);//RW
ZKUtil.multiOrSequential(zkw,new LinkedList<>(),false);//RW
String path=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSimpleMulti");//RW
ZKUtil.multiOrSequential(zkw,singleCreate,false);//RW
assertTrue(ZKUtil.checkExists(zkw,path) != -1);//RW
ZKUtil.multiOrSequential(zkw,singleSetData,false);//RW
assertTrue(Bytes.equals(ZKUtil.getData(zkw,path),data));//RW
ZKUtil.multiOrSequential(zkw,singleDelete,false);//RW
assertEquals(-1,ZKUtil.checkExists(zkw,path));//RW
}