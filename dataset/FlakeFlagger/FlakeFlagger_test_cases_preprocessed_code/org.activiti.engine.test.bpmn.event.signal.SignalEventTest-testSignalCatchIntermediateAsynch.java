@Deployment(resources={"org/activiti/engine/test/bpmn/event/signal/SignalEventTests.catchAlertSignal.bpmn20.xml","org/activiti/engine/test/bpmn/event/signal/SignalEventTests.throwAlertSignalAsynch.bpmn20.xml"}) public void testSignalCatchIntermediateAsynch(){
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,managementService.createJobQuery().count());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,managementService.createJobQuery().count());
}