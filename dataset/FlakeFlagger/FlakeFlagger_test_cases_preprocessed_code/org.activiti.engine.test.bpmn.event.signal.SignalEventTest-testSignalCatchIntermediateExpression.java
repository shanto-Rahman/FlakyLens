@Deployment(resources={"org/activiti/engine/test/bpmn/event/signal/SignalEventTests.catchAlertSignalExpression.bpmn20.xml","org/activiti/engine/test/bpmn/event/signal/SignalEventTests.throwAlertSignalExpression.bpmn20.xml"}) public void testSignalCatchIntermediateExpression(){
assertEquals(1,createEventSubscriptionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}