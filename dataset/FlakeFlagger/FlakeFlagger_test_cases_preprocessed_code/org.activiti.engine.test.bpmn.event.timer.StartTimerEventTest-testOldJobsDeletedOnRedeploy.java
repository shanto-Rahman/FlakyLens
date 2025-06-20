public void testOldJobsDeletedOnRedeploy(){
assertEquals(i + 1,repositoryService.createDeploymentQuery().count());
assertEquals(i + 1,repositoryService.createProcessDefinitionQuery().count());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
}