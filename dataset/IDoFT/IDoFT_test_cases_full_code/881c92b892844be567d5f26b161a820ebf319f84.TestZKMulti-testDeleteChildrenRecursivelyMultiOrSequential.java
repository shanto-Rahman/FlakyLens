@Test public void testDeleteChildrenRecursivelyMultiOrSequential() throws Exception {
  String parentZNode1="/testdeleteChildren1";
  String parentZNode2="/testdeleteChildren2";
  String parentZNode3="/testdeleteChildren3";
  createZNodeTree(parentZNode1);
  createZNodeTree(parentZNode2);
  createZNodeTree(parentZNode3);
  ZKUtil.deleteChildrenRecursivelyMultiOrSequential(zkw,true,parentZNode1,parentZNode2,parentZNode3);
  assertTrue("Wrongly deleted parent znode 1!",ZKUtil.checkExists(zkw,parentZNode1) > -1);
  List<String> children=zkw.getRecoverableZooKeeper().getChildren(parentZNode1,false);
  assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
  assertTrue("Wrongly deleted parent znode 2!",ZKUtil.checkExists(zkw,parentZNode2) > -1);
  children=zkw.getRecoverableZooKeeper().getChildren(parentZNode2,false);
  assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
  assertTrue("Wrongly deleted parent znode 3!",ZKUtil.checkExists(zkw,parentZNode3) > -1);
  children=zkw.getRecoverableZooKeeper().getChildren(parentZNode3,false);
  assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
}
