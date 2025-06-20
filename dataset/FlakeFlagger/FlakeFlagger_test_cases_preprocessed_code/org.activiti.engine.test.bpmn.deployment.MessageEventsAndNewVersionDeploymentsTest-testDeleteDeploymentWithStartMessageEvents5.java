public void testDeleteDeploymentWithStartMessageEvents5(){
fail();
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId1).singleResult().getId(),runtimeService.createProcessInstanceQuery().singleResult().getProcessDefinitionId());
}