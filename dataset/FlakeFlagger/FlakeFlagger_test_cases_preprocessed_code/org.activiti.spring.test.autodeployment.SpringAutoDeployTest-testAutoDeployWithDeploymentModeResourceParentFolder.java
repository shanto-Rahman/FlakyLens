public void testAutoDeployWithDeploymentModeResourceParentFolder(){
assertEquals(2,repositoryService.createDeploymentQuery().count());
assertEquals(4,repositoryService.createProcessDefinitionQuery().count());
}