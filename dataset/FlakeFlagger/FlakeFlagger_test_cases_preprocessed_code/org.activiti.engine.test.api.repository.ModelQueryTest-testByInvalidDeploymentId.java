public void testByInvalidDeploymentId(){
assertNull(query.singleResult());
assertEquals(0,query.count());
}