@Deployment(resources={"org/activiti/engine/test/bpmn/gateway/EventBasedGatewayTest.testCatchAlertAndTimer.bpmn20.xml"}) public void testCatchTimerCancelsSignal(){
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,managementService.createJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().count());
assertNotNull(task);
}