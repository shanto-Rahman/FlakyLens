@Test public void testRunSequentialOnMultiFailure() throws Exception {
  String path1=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential1");
  String path2=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential2");
  String path3=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential3");
  String path4=ZNodePaths.joinZNode(zkw.getZNodePaths().baseZNode,"runSequential4");
  LinkedList<ZKUtilOp> ops=new LinkedList<>();
  ops.add(ZKUtilOp.createAndFailSilent(path1,Bytes.toBytes(path1)));
  ops.add(ZKUtilOp.createAndFailSilent(path2,Bytes.toBytes(path2)));
  ZKUtil.multiOrSequential(zkw,ops,false);
  ops=new LinkedList<>();
  ops.add(ZKUtilOp.setData(path1,Bytes.add(Bytes.toBytes(path1),Bytes.toBytes(path1))));
  ops.add(ZKUtilOp.deleteNodeFailSilent(path2));
  ops.add(ZKUtilOp.deleteNodeFailSilent(path3));
  ops.add(ZKUtilOp.createAndFailSilent(path4,Bytes.add(Bytes.toBytes(path4),Bytes.toBytes(path4))));
  ZKUtil.multiOrSequential(zkw,ops,true);
  assertTrue(Bytes.equals(ZKUtil.getData(zkw,path1),Bytes.add(Bytes.toBytes(path1),Bytes.toBytes(path1))));
  assertEquals(-1,ZKUtil.checkExists(zkw,path2));
  assertEquals(-1,ZKUtil.checkExists(zkw,path3));
  assertNotEquals(-1,ZKUtil.checkExists(zkw,path4));
}
