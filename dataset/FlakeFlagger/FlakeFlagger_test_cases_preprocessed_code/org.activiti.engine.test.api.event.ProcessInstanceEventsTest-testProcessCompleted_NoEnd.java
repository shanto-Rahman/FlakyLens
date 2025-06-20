@Deployment(resources={"org/activiti/engine/test/api/event/ProcessInstanceEventsTest.noEndProcess.bpmn20.xml"}) public void testProcessCompleted_NoEnd() throws Exception {
assertEquals("ActivitiEventType.PROCESS_COMPLETED was expected 1 time.",1,listener.filterEvents(ActivitiEventType.PROCESS_COMPLETED).size());
}