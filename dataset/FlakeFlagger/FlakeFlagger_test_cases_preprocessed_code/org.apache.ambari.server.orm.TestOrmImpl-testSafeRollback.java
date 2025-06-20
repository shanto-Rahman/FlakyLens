/** 
 * Rollback test
 */
@Test public void testSafeRollback(){
EntityManager entityManager=injector.getInstance(OrmTestHelper.class).getEntityManager();//RW
assertNull("transaction was not rolled back",injector.getInstance(ClusterDAO.class).findByName(testClusterName));//RW
}