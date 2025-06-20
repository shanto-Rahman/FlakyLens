@Deployment(resources={"org/activiti/engine/test/bpmn/subprocess/transaction/TransactionSubProcessTest.testSimpleCase.bpmn20.xml"}) public void testSimpleCaseTxSuccessful(){
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookHotel").count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertNotNull(task);
assertTrue(activeActivityIds.contains("afterSuccess"));
assertNotNull(eventSubscriptionEntity.getConfiguration());
assertNotNull(eventScopeExecution);
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookHotel").executionId(eventScopeExecution.getId()).count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").executionId(eventScopeExecution.getId()).count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoChargeCard").executionId(eventScopeExecution.getId()).count());
assertNull(runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
assertNull(runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
assertNull(runtimeService.getVariable(processInstance.getId(),"undoChargeCard"));
assertEquals(0,runtimeService.createExecutionQuery().count());
}