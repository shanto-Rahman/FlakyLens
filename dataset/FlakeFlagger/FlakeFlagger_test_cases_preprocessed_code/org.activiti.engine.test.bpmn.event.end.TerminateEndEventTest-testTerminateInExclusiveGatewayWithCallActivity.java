@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateInExclusiveGatewayWithCallActivity.bpmn","org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.subProcessNoTerminate.bpmn"}) public void testTerminateInExclusiveGatewayWithCallActivity() throws Exception {
assertNotNull(subProcessInstance);
}