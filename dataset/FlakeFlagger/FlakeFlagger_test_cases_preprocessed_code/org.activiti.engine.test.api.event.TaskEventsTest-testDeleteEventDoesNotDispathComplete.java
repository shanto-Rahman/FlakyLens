@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testDeleteEventDoesNotDispathComplete() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
if (task != null) {
if (task != null) {
}
}
}