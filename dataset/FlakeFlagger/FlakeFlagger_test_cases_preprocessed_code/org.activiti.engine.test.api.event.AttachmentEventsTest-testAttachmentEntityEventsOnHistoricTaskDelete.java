public void testAttachmentEntityEventsOnHistoricTaskDelete() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(task);
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