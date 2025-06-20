@Deployment(resources={"org/activiti/engine/test/bpmn/event/signal/SignalEventTests.catchAlertSignal.bpmn20.xml","org/activiti/engine/test/bpmn/event/signal/SignalEventTests.throwAlertSignal.bpmn20.xml"}) public void testSignalCatchIntermediate(){
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}