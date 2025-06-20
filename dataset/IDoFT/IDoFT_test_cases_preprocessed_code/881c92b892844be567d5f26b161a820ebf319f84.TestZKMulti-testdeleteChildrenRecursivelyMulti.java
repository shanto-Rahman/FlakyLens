/** 
 * Verifies that for the given root node, it should delete all the child nodes recursively using multi-update api.
 */
@Test public void testdeleteChildrenRecursivelyMulti() throws Exception {
ZKUtil.deleteChildrenRecursivelyMultiOrSequential(zkw,true,parentZNode);//RW
assertTrue("Wrongly deleted parent znode!",ZKUtil.checkExists(zkw,parentZNode) > -1);//RW
List<String> children=zkw.getRecoverableZooKeeper().getChildren(parentZNode,false);//RW
assertEquals("Failed to delete child znodes!",0,children.size());
}