@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testQueryByDeploymentIdIn() throws Exception {
assertNotNull(taskService.createTaskQuery().deploymentIdIn(deploymentIds).singleResult());
assertEquals(1,taskService.createTaskQuery().deploymentIdIn(deploymentIds).count());
assertNotNull(taskService.createTaskQuery().deploymentIdIn(deploymentIds).singleResult());
assertEquals(1,taskService.createTaskQuery().deploymentIdIn(deploymentIds).count());
assertNull(taskService.createTaskQuery().deploymentIdIn(deploymentIds).singleResult());
assertEquals(0,taskService.createTaskQuery().deploymentIdIn(deploymentIds).count());
}