@Test public void testDeleteChildrenRecursivelyMultiOrSequential() throws Exception {
ZKUtil.deleteChildrenRecursivelyMultiOrSequential(zkw,true,parentZNode1,parentZNode2,parentZNode3);//RW
assertTrue("Wrongly deleted parent znode 1!",ZKUtil.checkExists(zkw,parentZNode1) > -1);//RW
List<String> children=zkw.getRecoverableZooKeeper().getChildren(parentZNode1,false);//RW
assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
assertTrue("Wrongly deleted parent znode 2!",ZKUtil.checkExists(zkw,parentZNode2) > -1);//RW
children=zkw.getRecoverableZooKeeper().getChildren(parentZNode2,false);//RW
assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
assertTrue("Wrongly deleted parent znode 3!",ZKUtil.checkExists(zkw,parentZNode3) > -1);//RW
children=zkw.getRecoverableZooKeeper().getChildren(parentZNode3,false);//RW
assertEquals("Failed to delete child znodes of parent znode 1!",0,children.size());
}