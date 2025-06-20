@Deployment(resources={"org/activiti/engine/test/bpmn/event/signal/SignalEventTests.catchMultipleSignals.bpmn20.xml","org/activiti/engine/test/bpmn/event/signal/SignalEventTests.throwAlertSignal.bpmn20.xml","org/activiti/engine/test/bpmn/event/signal/SignalEventTests.throwAbortSignal.bpmn20.xml"}) public void testSignalCatchDifferentSignals(){
assertEquals(2,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertNotNull(taskAfterAbort);
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}