@Deployment public void testCatchSignalAndMessageAndTimer(){
assertEquals(2,createEventSubscriptionQuery().count());
assertEquals(1,messageEventSubscriptionQuery.count());
assertEquals(1,createEventSubscriptionQuery().eventType("signal").count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,managementService.createTimerJobQuery().count());
assertNotNull(execution);
assertNotNull(execution);
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
assertNotNull(task);
}