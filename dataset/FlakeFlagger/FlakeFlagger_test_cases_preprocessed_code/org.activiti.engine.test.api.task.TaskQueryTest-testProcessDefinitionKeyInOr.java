@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testProcessDefinitionKeyInOr() throws Exception {
assertEquals(0,taskService.createTaskQuery().or().taskId("invalid").processDefinitionKeyIn(includeIds).count());
assertEquals(0,taskService.createTaskQuery().or().taskId("invalid").processDefinitionKeyIn(includeIds).count());
assertEquals(1,taskService.createTaskQuery().or().taskId("invalid").processDefinitionKeyIn(includeIds).count());
}