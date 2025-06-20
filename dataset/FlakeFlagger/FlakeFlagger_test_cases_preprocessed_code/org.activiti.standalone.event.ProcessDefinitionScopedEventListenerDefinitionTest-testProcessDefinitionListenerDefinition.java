/** 
 * Test to verify listeners defined in the BPMN xml are added to the process definition and are active.
 */
@Deployment public void testProcessDefinitionListenerDefinition() throws Exception {
assertNotNull(testListenerBean);
assertFalse(testListenerBean.getEventsReceived().isEmpty());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(testListenerBean.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertTrue(event.getEntity() instanceof ProcessInstance);
assertEquals(processInstance.getId(),((ProcessInstance)event.getEntity()).getId());
assertFalse(events.isEmpty());
if (ActivitiEventType.ENTITY_CREATED == e.getType()) {
if (ActivitiEventType.ENTITY_DELETED == e.getType()) {
}
}
assertTrue(insertFound);
assertTrue(deleteFound);
}