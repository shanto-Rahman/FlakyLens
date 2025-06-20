@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessDefinitionEvents() throws Exception {
assertNotNull(processDefinition);
assertEquals(2,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
assertEquals("test",((ProcessDefinition)event.getEntity()).getCategory());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
assertEquals(ActivitiEventType.ENTITY_SUSPENDED,event.getType());
assertEquals(ActivitiEventType.ENTITY_ACTIVATED,event.getType());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(processDefinition.getId(),((ProcessDefinition)event.getEntity()).getId());
}