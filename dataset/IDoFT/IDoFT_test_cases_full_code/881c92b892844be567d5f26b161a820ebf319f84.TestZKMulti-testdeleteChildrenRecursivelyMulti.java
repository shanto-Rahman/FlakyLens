/** 
 * Verifies that for the given root node, it should delete all the child nodes recursively using multi-update api.
 */
@Test public void testdeleteChildrenRecursivelyMulti() throws Exception {
  String parentZNode="/testRootMulti";
  createZNodeTree(parentZNode);
  ZKUtil.deleteChildrenRecursivelyMultiOrSequential(zkw,true,parentZNode);
  assertTrue("Wrongly deleted parent znode!",ZKUtil.checkExists(zkw,parentZNode) > -1);
  List<String> children=zkw.getRecoverableZooKeeper().getChildren(parentZNode,false);
  assertEquals("Failed to delete child znodes!",0,children.size());
}
