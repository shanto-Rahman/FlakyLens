@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testIncludeBinaryVariablesOr() throws Exception {
assertNotNull(task);
assertNotNull(task);
assertNotNull(task.getProcessVariables());
assertEquals("It is I, le binary",new String(bytes));
assertNotNull(task);
assertNotNull(task.getTaskLocalVariables());
assertEquals("It is I, le binary",new String(bytes));
}