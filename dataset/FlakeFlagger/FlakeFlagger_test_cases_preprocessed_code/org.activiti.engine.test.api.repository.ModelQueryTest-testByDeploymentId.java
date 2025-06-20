public void testByDeploymentId(){
assertEquals(0,repositoryService.createModelQuery().deploymentId(deployment.getId()).count());
assertEquals(0,repositoryService.createModelQuery().deployed().count());
assertEquals(1,repositoryService.createModelQuery().notDeployed().count());
assertEquals(1,repositoryService.createModelQuery().deploymentId(deployment.getId()).count());
assertEquals(1,repositoryService.createModelQuery().deployed().count());
assertEquals(0,repositoryService.createModelQuery().notDeployed().count());
assertEquals(0,repositoryService.createDeploymentQuery().count());
assertEquals(0,repositoryService.createModelQuery().deploymentId(deployment.getId()).count());
assertEquals(1,repositoryService.createModelQuery().notDeployed().count());
assertEquals(1,repositoryService.createModelQuery().count());
}