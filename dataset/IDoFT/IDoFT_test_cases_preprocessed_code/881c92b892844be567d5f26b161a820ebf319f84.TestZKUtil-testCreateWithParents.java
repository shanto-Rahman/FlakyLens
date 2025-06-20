/** 
 * Create a znode with data
 */
@Test public void testCreateWithParents() throws KeeperException, InterruptedException {
ZKUtil.createWithParents(ZKW,"/l1/l2/l3/l4/testCreateWithParents",expectedData);//RW
byte[] data=ZKUtil.getData(ZKW,"/l1/l2/l3/l4/testCreateWithParents");//RW
assertTrue(Bytes.equals(expectedData,data));
ZKUtil.deleteNodeRecursively(ZKW,"/l1");//RW
ZKUtil.createWithParents(ZKW,"/testCreateWithParents",expectedData);//RW
data=ZKUtil.getData(ZKW,"/testCreateWithParents");//RW
assertTrue(Bytes.equals(expectedData,data));
ZKUtil.deleteNodeRecursively(ZKW,"/testCreateWithParents");//RW
}