@Deployment public void testNonExclusiveService(){
assertNotNull(job);
assertFalse(((JobEntity)job).isExclusive());
assertEquals(0,managementService.createJobQuery().count());
}