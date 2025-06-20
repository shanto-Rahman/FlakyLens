/** 
 * Test to verify listeners defined in the BPMN xml are added to the process definition and are active, for all entity types
 */
@Deployment public void testProcessDefinitionListenerDefinitionEntities() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertNotNull(theListener);
assertEquals(0,theListener.getEventsReceived().size());
assertEquals(2,theListener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,theListener.getEventsReceived().get(0).getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,theListener.getEventsReceived().get(1).getType());
}