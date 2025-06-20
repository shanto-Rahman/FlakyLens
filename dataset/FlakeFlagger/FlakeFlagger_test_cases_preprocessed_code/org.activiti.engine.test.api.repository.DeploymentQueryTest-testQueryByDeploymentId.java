public void testQueryByDeploymentId(){
assertNotNull(query.singleResult());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}