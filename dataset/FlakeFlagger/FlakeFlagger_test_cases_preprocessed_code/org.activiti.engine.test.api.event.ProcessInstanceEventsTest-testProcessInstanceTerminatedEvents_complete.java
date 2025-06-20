@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceTerminatedEvents_complete() throws Exception {
assertNotNull(processInstance);
assertEquals("There should be no ActivitiEventType.PROCESS_TERMINATED event after process complete.",0,processTerminatedEvents.size());
}