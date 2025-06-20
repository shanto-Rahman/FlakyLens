/** 
 * Check all events for tasks not related to a process-instance
 */
public void testStandaloneTaskEvents() throws Exception {
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.TASK_CREATED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals("owner",taskFromEvent.getOwner());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_ASSIGNED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals("kermit",taskFromEvent.getAssignee());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TASK_COMPLETED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertNull(event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
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