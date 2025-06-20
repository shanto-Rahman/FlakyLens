@Deployment public void testCancelEndConcurrent(){
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookHotel").count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertNotNull(task);
assertEquals("askCustomer",task.getTaskDefinitionKey());
assertTrue(activeActivityIds.contains("afterCancellation"));
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").count());
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("undoBookHotel").count());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("undoBookFlight").count());
}
assertEquals(0,runtimeService.createExecutionQuery().count());
}