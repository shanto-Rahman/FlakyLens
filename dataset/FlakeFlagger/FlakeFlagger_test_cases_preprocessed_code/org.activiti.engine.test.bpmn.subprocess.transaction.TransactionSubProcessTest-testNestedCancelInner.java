@Deployment public void testNestedCancelInner(){
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertEquals(5,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookHotel").count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookFlight").count());
assertNotNull(taskInner);
assertNotNull(taskOuter);
assertTrue(activeActivityIds.contains("afterInnerCancellation"));
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookHotel").count());
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookFlight").count());
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"innerTxundoBookHotel"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"innerTxundoBookFlight"));
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(5,historyService.createHistoricActivityInstanceQuery().activityId("innerTxundoBookHotel").count());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("innerTxundoBookFlight").count());
}
assertEquals(0,runtimeService.createExecutionQuery().count());
}