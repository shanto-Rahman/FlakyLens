@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceIdentityLinkEvents() throws Exception {
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(processInstance.getId(),event.getExecutionId());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals("kermit",link.getUserId());
assertEquals("test",link.getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertTrue(event.getEntity() instanceof IdentityLink);
assertEquals("kermit",link.getUserId());
assertEquals("test",link.getType());
}