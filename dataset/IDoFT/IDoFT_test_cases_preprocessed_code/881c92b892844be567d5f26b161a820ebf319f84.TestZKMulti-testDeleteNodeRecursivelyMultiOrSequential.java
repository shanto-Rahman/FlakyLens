@Test public void testDeleteNodeRecursivelyMultiOrSequential() throws Exception {
ZKUtil.deleteNodeRecursivelyMultiOrSequential(zkw,false,parentZNode1,parentZNode2,parentZNode3);//RW
assertEquals("Parent znode 1 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode1));//RW
assertEquals("Parent znode 2 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode2));//RW
assertEquals("Parent znode 3 should be deleted.",-1,ZKUtil.checkExists(zkw,parentZNode3));//RW
}