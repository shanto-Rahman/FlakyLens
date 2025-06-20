@Deployment public void testResetExpiredJobs(){
assertEquals(1,managementService.createJobQuery().count());
assertEquals(0,expiredJobs.size());
assertEquals(0,expiredJobs.size());
assertTrue(expiredJobs.size() > 0);
assertEquals(3,managementService.createJobQuery().count());
assertEquals(2,unlockedJobs.size());
assertNull(jobEntity.getLockOwner());
assertNull(jobEntity.getLockExpirationTime());
}