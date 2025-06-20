@Deployment(resources={"org/activiti/engine/test/api/runtime/RuntimeServiceTest.catchAlertMessage.bpmn20.xml","org/activiti/engine/test/api/runtime/RuntimeServiceTest.catchPanicMessage.bpmn20.xml"}) public void testMessageEventReceived(){
assertEquals(12,runtimeService.createExecutionQuery().count());
assertEquals(executions - 1,runtimeService.createExecutionQuery().messageEventSubscriptionName("alert").count());
assertEquals(executions - 1,runtimeService.createExecutionQuery().messageEventSubscriptionName("panic").count());
}