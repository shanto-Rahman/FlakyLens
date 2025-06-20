@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testProcessCategoryInOr() throws Exception {
assertNotNull(task);
assertEquals("theTask",task.getTaskDefinitionKey());
assertEquals(processInstance.getId(),task.getProcessInstanceId());
assertNotNull(task);
assertEquals("theTask",task.getTaskDefinitionKey());
assertEquals(processInstance.getId(),task.getProcessInstanceId());
assertEquals(0,taskService.createTaskQuery().or().taskId("invalid").processCategoryIn(Collections.singletonList("unexisting")).count());
}