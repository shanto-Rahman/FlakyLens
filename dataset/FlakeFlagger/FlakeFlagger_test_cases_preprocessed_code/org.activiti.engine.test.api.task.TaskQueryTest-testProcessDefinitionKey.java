@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testProcessDefinitionKey() throws Exception {
assertEquals(1,tasks.size());
assertEquals(processInstance.getId(),tasks.get(0).getProcessInstanceId());
assertEquals(0,taskService.createTaskQuery().processDefinitionKey("unexisting").count());
}