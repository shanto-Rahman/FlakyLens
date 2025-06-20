/** 
 * Create a bunch of znodes in a hierarchy, try deleting one that has childs (it will fail), then delete it recursively, then delete the last znode
 */
@Test public void testZNodeDeletes() throws Exception {
ZKUtil.createWithParents(ZKW,"/l1/l2/l3/l4");//RW
ZKUtil.deleteNode(ZKW,"/l1/l2");//RW
fail("We should not be able to delete if znode has childs");
assertNotNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2/l3/l4",null));//RW
ZKUtil.deleteNodeRecursively(ZKW,"/l1/l2");//RW
assertNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2/l3/l4",null));//RW
ZKUtil.deleteNodeRecursively(ZKW,"/l1/l2");//RW
ZKUtil.deleteNode(ZKW,"/l1");//RW
assertNull(ZKUtil.getDataNoWatch(ZKW,"/l1/l2",null));//RW
}