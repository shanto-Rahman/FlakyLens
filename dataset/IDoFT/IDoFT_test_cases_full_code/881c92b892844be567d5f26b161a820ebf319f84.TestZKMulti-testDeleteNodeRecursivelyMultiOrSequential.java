@Test public void testDeleteNodeRecursivelyMultiOrSequential() throws Exception {
  String parentZNode1="/testdeleteNode1";
  String parentZNode2="/testdeleteNode2";
  String parentZNode3="/testdeleteNode3";
  createZNodeTree(parentZNode1);
  createZNodeTree(parentZNode2);
  createZNodeTree(parentZNode3);
  ZKUtil.deleteNodeRecursivelyMultiOrSequential(zkw,false,parentZNode1,parentZNode2,parentZNode3);
  assertEquals("Parent znode 1 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode1));
  assertEquals("Parent znode 2 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode2));
  assertEquals("Parent znode 3 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode3));
}
