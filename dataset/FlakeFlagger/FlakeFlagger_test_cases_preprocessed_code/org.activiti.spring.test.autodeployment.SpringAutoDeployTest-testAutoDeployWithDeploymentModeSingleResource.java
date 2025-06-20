public void testAutoDeployWithDeploymentModeSingleResource(){
assertEquals(3,repositoryService.createDeploymentQuery().count());
assertEquals(3,repositoryService.createProcessDefinitionQuery().count());
}