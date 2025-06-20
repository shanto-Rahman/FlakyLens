@Deployment(resources={"org/activiti/engine/test/api/event/ProcessInstanceEventsTest.parallelGatewayTwoEndsProcess.bpmn20.xml"}) public void testProcessCompleted_ParallelGatewayTwoEnds() throws Exception {
assertEquals("ActivitiEventType.PROCESS_COMPLETED was expected 1 time.",1,events.size());
}