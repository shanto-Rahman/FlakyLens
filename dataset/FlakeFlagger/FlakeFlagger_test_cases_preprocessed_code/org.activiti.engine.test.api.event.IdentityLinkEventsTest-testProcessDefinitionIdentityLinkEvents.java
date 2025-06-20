@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessDefinitionIdentityLinkEvents() throws Exception {
assertNotNull(processDefinition);
assertEquals(4,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals(processDefinition.getId(),event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals(processDefinition.getId(),event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals(processDefinition.getId(),event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals(processDefinition.getId(),event.getProcessDefinitionId());
assertNull(event.getProcessInstanceId());
assertNull(event.getExecutionId());
}