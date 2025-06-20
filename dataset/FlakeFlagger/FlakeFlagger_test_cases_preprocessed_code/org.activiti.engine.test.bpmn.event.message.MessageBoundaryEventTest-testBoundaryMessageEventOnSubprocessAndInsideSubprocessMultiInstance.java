@Deployment public void testBoundaryMessageEventOnSubprocessAndInsideSubprocessMultiInstance(){
assertEquals(18,runtimeService.createExecutionQuery().count());
assertNotNull(userTasks);
assertEquals(5,userTasks.size());
assertNotNull(executions);
assertEquals(5,executions.size());
assertNotNull(executions);
assertEquals(1,executions.size());
assertEquals(0,executions.size());
assertNotNull(userTask);
assertEquals("taskAfterOuterMessageBoundary",userTask.getTaskDefinitionKey());
}