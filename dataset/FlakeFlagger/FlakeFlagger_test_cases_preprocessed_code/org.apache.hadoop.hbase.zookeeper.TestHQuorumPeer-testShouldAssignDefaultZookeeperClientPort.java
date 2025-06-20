/** 
 * Test Case for HBASE-2305
 */
public void testShouldAssignDefaultZookeeperClientPort(){
assertNotNull(p);
assertEquals(2181,p.get("hbase.zookeeper.property.clientPort"));
}