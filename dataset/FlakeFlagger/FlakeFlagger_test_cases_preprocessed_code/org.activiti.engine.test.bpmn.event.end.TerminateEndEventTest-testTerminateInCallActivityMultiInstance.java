@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateInCallActivityMulitInstance.bpmn","org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.subProcessTerminate.bpmn"}) public void testTerminateInCallActivityMultiInstance() throws Exception {
assertTrue(executionEntities > 0);
}