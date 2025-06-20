@Deployment public void testQueryBySignalSubscriptionName(){
assertNotNull(execution);
assertNull(execution);
assertEquals(2,runtimeService.createExecutionQuery().signalEventSubscriptionName("alert").count());
}