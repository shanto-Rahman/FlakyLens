@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceIdentityDeleteCandidateGroupEvents() throws Exception {
assertNotNull(task);
assertEquals(6,listener.getEventsReceived().size());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(1,listener.getEventsReceived().size());
}