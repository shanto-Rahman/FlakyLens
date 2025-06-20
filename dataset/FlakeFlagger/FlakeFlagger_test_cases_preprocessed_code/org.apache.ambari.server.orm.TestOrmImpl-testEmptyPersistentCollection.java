/** 
 * persistence provider is responsible for returning empty collection if relation doesn't exists
 */
@Test public void testEmptyPersistentCollection(){
ClusterDAO clusterDAO=injector.getInstance(ClusterDAO.class);//RW
assertTrue("empty relation wasn't instantiated",clusterEntity.getHostEntities() != null);
}