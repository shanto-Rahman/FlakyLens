@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceCancelledEvents_complete() throws Exception {
assertNotNull(processInstance);
assertEquals("There should be no ActivitiEventType.PROCESS_CANCELLED event after process complete.",0,processCancelledEvents.size());
assertEquals("There should be no ActivitiEventType.ACTIVITY_CANCELLED event.",0,taskCancelledEvents.size());
}