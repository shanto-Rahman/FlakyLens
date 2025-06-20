/** 
 * Create a bunch of znodes in a hierarchy, try deleting one that has childs (it will fail), then delete it recursively, then delete the last znode
 */
@Test public void testZNodeDeletes() throws Exception {
  ZKUtil.createWithParents(ZKW,"/l1/l2/l3/l4");
  try {
    ZKUtil.deleteNode(ZKW,"/l1/l2");
    fail("We should not be able to delete if znode has childs");
  }
 catch (  KeeperException ex) {
    assertNotNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2/l3/l4",null));
  }
  ZKUtil.deleteNodeRecursively(ZKW,"/l1/l2");
  assertNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2/l3/l4",null));
  ZKUtil.deleteNodeRecursively(ZKW,"/l1/l2");
  ZKUtil.deleteNode(ZKW,"/l1");
  assertNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2",null));
}
