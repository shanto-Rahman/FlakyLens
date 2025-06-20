public void testAutoDeployWithDeploymentModeDefault(){
assertEquals(1,repositoryService.createDeploymentQuery().count());
assertEquals(3,repositoryService.createProcessDefinitionQuery().count());
}