/** 
 * Verifies that for the given root node, it should delete all the nodes recursively using multi-update api.
 */
@Test public void testDeleteNodeRecursivelyMulti() throws Exception {
  String parentZNode="/testdeleteNodeRecursivelyMulti";
  createZNodeTree(parentZNode);
  ZKUtil.deleteNodeRecursively(zkw,parentZNode);
  assertEquals("Parent znode should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode));
}
