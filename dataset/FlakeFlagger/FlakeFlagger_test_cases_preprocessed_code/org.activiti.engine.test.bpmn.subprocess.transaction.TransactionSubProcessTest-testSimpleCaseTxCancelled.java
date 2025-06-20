@Deployment(resources={"org/activiti/engine/test/bpmn/subprocess/transaction/TransactionSubProcessTest.testSimpleCase.bpmn20.xml"}) public void testSimpleCaseTxCancelled(){
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookHotel").count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertNotNull(task);
assertEquals("askCustomer",task.getTaskDefinitionKey());
assertNotNull(execution);
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").count());
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoChargeCard"));
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("undoBookFlight").count());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("undoBookHotel").count());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("undoChargeCard").count());
}
assertEquals(0,runtimeService.createExecutionQuery().count());
}