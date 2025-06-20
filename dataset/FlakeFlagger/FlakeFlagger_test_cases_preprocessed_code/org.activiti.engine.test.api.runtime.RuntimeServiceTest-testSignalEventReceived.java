@Deployment(resources={"org/activiti/engine/test/api/runtime/RuntimeServiceTest.catchAlertSignal.bpmn20.xml","org/activiti/engine/test/api/runtime/RuntimeServiceTest.catchPanicSignal.bpmn20.xml"}) public void testSignalEventReceived(){
assertEquals(15,runtimeService.createExecutionQuery().count());
assertEquals(9,runtimeService.createExecutionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(executions - 1,runtimeService.createExecutionQuery().signalEventSubscriptionName("alert").count());
assertEquals(executions - 1,runtimeService.createExecutionQuery().signalEventSubscriptionName("panic").count());
}