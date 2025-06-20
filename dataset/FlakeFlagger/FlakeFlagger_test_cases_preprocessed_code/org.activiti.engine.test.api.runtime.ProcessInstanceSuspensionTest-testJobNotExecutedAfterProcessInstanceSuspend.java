@Deployment public void testJobNotExecutedAfterProcessInstanceSuspend(){
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(1,managementService.createSuspendedJobQuery().count());
assertNull(job);
assertEquals(1,managementService.createSuspendedJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createSuspendedJobQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}