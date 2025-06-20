@Deployment public void testQueryBySignalSubscriptionNameBoundary(){
assertNotNull(execution);
assertNull(execution);
assertEquals(2,runtimeService.createExecutionQuery().signalEventSubscriptionName("Test signal").count());
}