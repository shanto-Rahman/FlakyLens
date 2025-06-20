private void testInterruptingUnderProcessDefinition(int expectedNumberOfEventSubscriptions,int numberOfExecutions){
assertNotNull(execution);
assertEquals(expectedNumberOfEventSubscriptions,createEventSubscriptionQuery().count());
assertEquals(numberOfExecutions,runtimeService.createExecutionQuery().count());
assertEquals("task",task.getTaskDefinitionKey());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
assertNotNull(execution);
assertEquals("eventSubProcessTask",task.getTaskDefinitionKey());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
}