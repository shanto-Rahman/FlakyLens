@Deployment(resources="org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml") public void testProcessVariableValueLikeIgnoreCase() throws Exception {
assertEquals(1,taskService.createTaskQuery().processVariableValueLikeIgnoreCase("mixed","azer%").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueLikeIgnoreCase("mixed","a%").count());
assertEquals(0,taskService.createTaskQuery().processVariableValueLikeIgnoreCase("mixed","Azz%").count());
}