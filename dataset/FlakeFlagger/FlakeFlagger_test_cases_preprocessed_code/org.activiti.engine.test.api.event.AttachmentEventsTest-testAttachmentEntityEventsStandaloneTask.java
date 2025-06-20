/** 
 * Test create, update and delete events of users.
 */
public void testAttachmentEntityEventsStandaloneTask() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(attachment.getId(),attachmentFromEvent.getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(attachment.getId(),attachmentFromEvent.getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(attachment.getId(),attachmentFromEvent.getId());
assertEquals("Description",attachmentFromEvent.getDescription());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(attachment.getId(),attachmentFromEvent.getId());
if (task != null && task.getId() != null) {
}
}
}