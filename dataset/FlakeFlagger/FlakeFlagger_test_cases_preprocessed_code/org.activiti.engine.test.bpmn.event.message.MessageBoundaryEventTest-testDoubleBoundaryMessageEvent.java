@Deployment public void testDoubleBoundaryMessageEvent(){
assertEquals(4,runtimeService.createExecutionQuery().count());
assertNotNull(userTask);
assertNotNull(execution1);
assertNotNull(execution2);
assertFalse(execution1.getId().equals(execution2.getId()));
fail();
assertNotNull(userTask);
assertEquals("taskAfterMessage_1",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertNotNull(userTask);
assertNull(execution1);
assertNull(execution2);
assertNotNull(userTask);
assertEquals("taskAfterTask",userTask.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}