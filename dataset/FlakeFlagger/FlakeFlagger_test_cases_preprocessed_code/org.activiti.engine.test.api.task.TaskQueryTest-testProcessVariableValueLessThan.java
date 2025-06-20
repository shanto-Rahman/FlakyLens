@Deployment(resources="org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml") public void testProcessVariableValueLessThan() throws Exception {
assertEquals(1,taskService.createTaskQuery().processVariableValueLessThan("number",12).count());
assertEquals(0,taskService.createTaskQuery().processVariableValueLessThan("number",10).count());
}