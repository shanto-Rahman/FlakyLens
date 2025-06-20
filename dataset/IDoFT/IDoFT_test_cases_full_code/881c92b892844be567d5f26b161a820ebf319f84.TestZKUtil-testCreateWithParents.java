/** 
 * Create a znode with data
 */
@Test public void testCreateWithParents() throws KeeperException, InterruptedException {
  byte[] expectedData=new byte[]{1,2,3};
  ZKUtil.createWithParents(ZKW,"/l1/l2/l3/l4/testCreateWithParents",expectedData);
  byte[] data=ZKUtil.getData(ZKW,"/l1/l2/l3/l4/testCreateWithParents");
  assertTrue(Bytes.equals(expectedData,data));
  ZKUtil.deleteNodeRecursively(ZKW,"/l1");
  ZKUtil.createWithParents(ZKW,"/testCreateWithParents",expectedData);
  data=ZKUtil.getData(ZKW,"/testCreateWithParents");
  assertTrue(Bytes.equals(expectedData,data));
  ZKUtil.deleteNodeRecursively(ZKW,"/testCreateWithParents");
}
