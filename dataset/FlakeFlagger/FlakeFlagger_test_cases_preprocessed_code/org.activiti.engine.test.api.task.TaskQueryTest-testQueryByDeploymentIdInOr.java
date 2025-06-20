@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testQueryByDeploymentIdInOr() throws Exception {
assertNotNull(taskService.createTaskQuery().or().taskId("invalid").deploymentIdIn(deploymentIds).singleResult());
assertEquals(1,taskService.createTaskQuery().or().taskId("invalid").deploymentIdIn(deploymentIds).count());
assertNotNull(taskService.createTaskQuery().or().taskId("invalid").deploymentIdIn(deploymentIds).singleResult());
assertEquals(1,taskService.createTaskQuery().or().taskId("invalid").deploymentIdIn(deploymentIds).count());
assertNull(taskService.createTaskQuery().deploymentIdIn(deploymentIds).singleResult());
assertEquals(0,taskService.createTaskQuery().or().taskId("invalid").deploymentIdIn(deploymentIds).count());
}