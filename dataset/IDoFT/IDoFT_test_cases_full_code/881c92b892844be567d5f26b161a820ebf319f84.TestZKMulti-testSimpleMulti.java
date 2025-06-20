@Test public void testSimpleMulti() throws Exception {
  ZKUtil.multiOrSequential(zkw,null,false);
  ZKUtil.multiOrSequential(zkw,new LinkedList<>(),false);
  String path=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"testSimpleMulti");
  LinkedList<ZKUtilOp> singleCreate=new LinkedList<>();
  singleCreate.add(ZKUtilOp.createAndFailSilent(path,new byte[0]));
  ZKUtil.multiOrSequential(zkw,singleCreate,false);
  assertTrue(ZKUtil.checkExists(zkw,path) != -1);
  LinkedList<ZKUtilOp> singleSetData=new LinkedList<>();
  byte[] data=Bytes.toBytes("foobar");
  singleSetData.add(ZKUtilOp.setData(path,data));
  ZKUtil.multiOrSequential(zkw,singleSetData,false);
  assertTrue(Bytes.equals(ZKUtil.getData(zkw,path),data));
  LinkedList<ZKUtilOp> singleDelete=new LinkedList<>();
  singleDelete.add(ZKUtilOp.deleteNodeFailSilent(path));
  ZKUtil.multiOrSequential(zkw,singleDelete,false);
  assertEquals(-1,ZKUtil.checkExists(zkw,path));
}
