/** 
 * to clarify: are cascade operations allowed?
 */
@Test public void testCascadeRemoveFail(){
ClusterServiceDAO clusterServiceDAO=injector.getInstance(ClusterServiceDAO.class);//RW
Assert.assertNull(clusterServiceDAO.findByClusterAndServiceNames(clusterName,serviceName));
}