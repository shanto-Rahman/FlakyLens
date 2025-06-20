@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testTaskEventsInProcess() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.TASK_CREATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_COMPLETED,event.getType());
assertNotNull(taskEntity.getDueDate());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
}