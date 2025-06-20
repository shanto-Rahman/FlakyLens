@Test public void testConcurrentModification() throws InterruptedException {
final ClusterDAO clusterDAO=injector.getInstance(ClusterDAO.class);//RW
assertEquals("cluster1",clusterEntity.getClusterName());
thread.start();
thread.join();
assertEquals("anotherName",clusterEntity.getClusterName());
thread.start();
thread.join();
assertNull(clusterDAO.findById(clusterEntity.getClusterId()));
thread.start();
thread.join();
assertEquals(result.size() + 1,(result=clusterDAO.findAll()).size());
thread.start();
thread.join();
assertEquals(result.size() + 1,(clusterDAO.findAll()).size());
}