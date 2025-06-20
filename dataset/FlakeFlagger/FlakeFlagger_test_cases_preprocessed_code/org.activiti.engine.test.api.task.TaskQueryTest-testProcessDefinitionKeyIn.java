@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testProcessDefinitionKeyIn() throws Exception {
assertEquals(13,taskService.createTaskQuery().processDefinitionKeyIn(includeIds).count());
assertEquals(0,taskService.createTaskQuery().processDefinitionKeyIn(includeIds).count());
assertEquals(1,taskService.createTaskQuery().processDefinitionKeyIn(includeIds).count());
}