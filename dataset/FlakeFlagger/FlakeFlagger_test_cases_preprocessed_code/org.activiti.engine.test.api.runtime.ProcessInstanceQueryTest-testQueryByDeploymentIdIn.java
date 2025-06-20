public void testQueryByDeploymentIdIn(){
assertEquals(PROCESS_DEPLOY_COUNT,instances.size());
assertEquals(deployment.getId(),processInstance.getDeploymentId());
assertEquals(new Integer(1),processInstance.getProcessDefinitionVersion());
assertEquals(PROCESS_DEFINITION_KEY,processInstance.getProcessDefinitionKey());
assertEquals("oneTaskProcessName",processInstance.getProcessDefinitionName());
assertEquals(PROCESS_DEPLOY_COUNT,runtimeService.createProcessInstanceQuery().deploymentIdIn(deploymentIds).count());
}