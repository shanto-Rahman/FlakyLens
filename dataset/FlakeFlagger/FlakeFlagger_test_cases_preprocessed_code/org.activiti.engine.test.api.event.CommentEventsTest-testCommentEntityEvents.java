@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testCommentEntityEvents() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertNotNull(task);
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(processInstance.getId(),event.getExecutionId());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(comment.getId(),commentFromEvent.getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(processInstance.getId(),event.getExecutionId());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(comment.getId(),commentFromEvent.getId());
}
}