/** 
 * Test confirming fix for ACT-1731
 */
@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testIncludeBinaryVariables() throws Exception {
assertNotNull(task);
assertNotNull(task);
assertNotNull(task.getProcessVariables());
assertEquals("It is I, le binary",new String(bytes));
assertNotNull(task);
assertNotNull(task.getTaskLocalVariables());
assertEquals("It is I, le binary",new String(bytes));
}