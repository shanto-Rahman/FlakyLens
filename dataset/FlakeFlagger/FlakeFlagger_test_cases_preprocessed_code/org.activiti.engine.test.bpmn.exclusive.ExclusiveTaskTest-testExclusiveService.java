@Deployment public void testExclusiveService(){
assertNotNull(job);
assertTrue(((JobEntity)job).isExclusive());
assertEquals(0,managementService.createJobQuery().count());
}