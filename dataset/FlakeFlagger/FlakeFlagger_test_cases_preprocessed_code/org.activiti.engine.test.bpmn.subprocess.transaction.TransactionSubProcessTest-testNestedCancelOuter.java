@Deployment public void testNestedCancelOuter(){
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertEquals(5,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookHotel").count());
assertEquals(1,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookFlight").count());
assertNotNull(taskInner);
assertNotNull(taskOuter);
assertTrue(activeActivityIds.contains("afterOuterCancellation"));
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookHotel").count());
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("innerTxundoBookFlight").count());
assertEquals(0,createEventSubscriptionQuery().eventType("compensate").activityId("undoBookFlight").count());
assertNull(runtimeService.getVariable(processInstance.getId(),"innerTxundoBookHotel"));
assertNull(runtimeService.getVariable(processInstance.getId(),"innerTxundoBookFlight"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
assertEquals(0,runtimeService.createExecutionQuery().count());
}