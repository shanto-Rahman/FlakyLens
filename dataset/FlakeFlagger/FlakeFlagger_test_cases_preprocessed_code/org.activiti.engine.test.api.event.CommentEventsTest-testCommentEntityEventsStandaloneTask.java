public void testCommentEntityEventsStandaloneTask() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertNotNull(task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(comment.getId(),commentFromEvent.getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertNull(event.getProcessDefinitionId());
assertEquals(comment.getId(),commentFromEvent.getId());
if (task != null && task.getId() != null) {
}
}
}