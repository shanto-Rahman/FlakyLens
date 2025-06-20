@Test public void testCleanZNode() throws Exception {
assertNotNull(ZKUtil.getData(zkw,nodeName));
assertNotNull(ZKUtil.getData(zkw,nodeName));
assertNull(ZKUtil.getData(zkw,nodeName));
}