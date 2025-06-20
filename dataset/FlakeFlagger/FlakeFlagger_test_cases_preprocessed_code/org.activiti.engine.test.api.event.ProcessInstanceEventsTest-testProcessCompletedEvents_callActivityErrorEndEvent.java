@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.testCatchErrorOnCallActivity-parent.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess.bpmn20.xml"}) public void testProcessCompletedEvents_callActivityErrorEndEvent() throws Exception {
assertEquals("Task in subprocess",task.getName());
assertEquals(1,subProcesses.size());
assertEquals("There should be exactly an ActivitiEventType.PROCESS_COMPLETED_WITH_ERROR_END_EVENT event after the task complete.",1,processCompletedEvents.size());
assertEquals(subProcesses.get(0).getId(),processCompletedEvent.getExecutionId());
assertEquals("Escalated Task",task.getName());
}