@Deployment(resources="org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml") public void testProcessVariableValueEqualsIgnoreCase() throws Exception {
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("mixed","azerTY").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("mixed","azerty").count());
assertEquals(0,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("mixed","uiop").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("upper","azerTY").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("upper","azerty").count());
assertEquals(0,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("upper","uiop").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("lower","azerTY").count());
assertEquals(1,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("lower","azerty").count());
assertEquals(0,taskService.createTaskQuery().processVariableValueEqualsIgnoreCase("lower","uiop").count());
}