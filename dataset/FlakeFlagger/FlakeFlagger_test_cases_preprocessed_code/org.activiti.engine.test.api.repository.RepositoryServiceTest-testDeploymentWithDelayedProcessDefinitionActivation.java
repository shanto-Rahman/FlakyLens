public void testDeploymentWithDelayedProcessDefinitionActivation(){
assertEquals(1,repositoryService.createDeploymentQuery().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().active().count());
fail();
assertEquals(1,repositoryService.createDeploymentQuery().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(0,repositoryService.createProcessDefinitionQuery().suspended().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().active().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
}