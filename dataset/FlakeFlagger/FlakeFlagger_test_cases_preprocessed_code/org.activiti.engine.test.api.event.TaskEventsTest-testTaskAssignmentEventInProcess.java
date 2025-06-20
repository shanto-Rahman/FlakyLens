@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testTaskAssignmentEventInProcess() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_ASSIGNED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals("kermit",taskFromEvent.getAssignee());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_ASSIGNED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals("newAssignee",taskFromEvent.getAssignee());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_ASSIGNED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals(null,taskFromEvent.getAssignee());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
}