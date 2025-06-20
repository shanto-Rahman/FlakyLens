/** 
 * Test auto incremented field and custom query example
 */
@Test public void testAutoIncrementedField(){
ClusterServiceDAO clusterServiceDAO=injector.getInstance(ClusterServiceDAO.class);//RW
assertNull(clusterServiceDAO.findByClusterAndServiceNames(clusterName,serviceName));
}