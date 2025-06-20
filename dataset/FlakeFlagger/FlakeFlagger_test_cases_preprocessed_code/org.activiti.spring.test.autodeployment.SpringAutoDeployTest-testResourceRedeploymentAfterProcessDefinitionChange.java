public void testResourceRedeploymentAfterProcessDefinitionChange() throws Exception {
assertEquals(1,repositoryService.createDeploymentQuery().count());
assertTrue(updatedBpmnFileContent.length() > originalBpmnFileContent.length());
assertEquals(2,repositoryService.createDeploymentQuery().count());
assertEquals(6,repositoryService.createProcessDefinitionQuery().count());
}