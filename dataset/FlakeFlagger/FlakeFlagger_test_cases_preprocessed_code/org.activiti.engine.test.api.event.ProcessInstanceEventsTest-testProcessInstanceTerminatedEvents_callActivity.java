@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateInCallActivity.bpmn","org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.subProcessTerminate.bpmn"}) public void testProcessInstanceTerminatedEvents_callActivity() throws Exception {
assertEquals("There should be exactly one ActivitiEventType.PROCESS_CANCELLED event after the task complete.",1,processTerminatedEvents.size());
assertThat(processCancelledEvent.getProcessDefinitionId(),containsString("terminateEndEventSubprocessExample"));
}