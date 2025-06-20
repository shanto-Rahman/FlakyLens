@Deployment public void testBoundaryMessageEventOnSubprocess(){
assertEquals(5,runtimeService.createExecutionQuery().count());
assertNotNull(userTask);
assertNotNull(executionMessageOne);
assertNotNull(userTask);
assertEquals("taskAfterMessage_one",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertNotNull(executionMessageTwo);
assertNotNull(userTask);
assertEquals("taskAfterMessage_two",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertNotNull(userTask);
assertNull(executionMessageOne);
assertNull(executionMessageTwo);
assertNotNull(userTask);
assertEquals("taskAfterSubProcess",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}