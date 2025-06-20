@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateInCallActivityConcurrentMulitInstance.bpmn","org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.subProcessConcurrentTerminate.bpmn"}) public void testTerminateInCallActivityConcurrentMulitInstance() throws Exception {
assertTrue(executionEntities > 0);
}