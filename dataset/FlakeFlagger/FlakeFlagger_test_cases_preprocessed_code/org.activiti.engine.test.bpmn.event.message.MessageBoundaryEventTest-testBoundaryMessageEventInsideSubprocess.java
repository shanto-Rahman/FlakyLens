@Deployment public void testBoundaryMessageEventInsideSubprocess(){
assertEquals(4,runtimeService.createExecutionQuery().count());
assertNotNull(userTask);
assertNotNull(execution);
assertNotNull(userTask);
assertEquals("taskAfterMessage",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertNotNull(userTask);
assertNull(execution);
assertNotNull(userTask);
assertEquals("taskAfterTask",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}