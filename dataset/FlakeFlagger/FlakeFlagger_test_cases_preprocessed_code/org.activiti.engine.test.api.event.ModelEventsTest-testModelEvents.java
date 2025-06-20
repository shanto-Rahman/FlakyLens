/** 
 * Test create, update and delete events of model entities.
 */
public void testModelEvents() throws Exception {
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,listener.getEventsReceived().get(0).getType());
assertEquals(model.getId(),((Model)((ActivitiEntityEvent)listener.getEventsReceived().get(0)).getEntity()).getId());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,listener.getEventsReceived().get(1).getType());
assertEquals(model.getId(),((Model)((ActivitiEntityEvent)listener.getEventsReceived().get(1)).getEntity()).getId());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,listener.getEventsReceived().get(0).getType());
assertEquals(model.getId(),((Model)((ActivitiEntityEvent)listener.getEventsReceived().get(0)).getEntity()).getId());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,listener.getEventsReceived().get(0).getType());
assertEquals(ActivitiEventType.ENTITY_UPDATED,listener.getEventsReceived().get(1).getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,listener.getEventsReceived().get(0).getType());
assertEquals(model.getId(),((Model)((ActivitiEntityEvent)listener.getEventsReceived().get(0)).getEntity()).getId());
if (model != null && repositoryService.getModel(model.getId()) != null) {
}
}