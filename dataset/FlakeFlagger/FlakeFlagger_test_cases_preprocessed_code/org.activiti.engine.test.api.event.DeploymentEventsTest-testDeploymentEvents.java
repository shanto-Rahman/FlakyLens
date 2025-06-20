/** 
 * Test create, update and delete events of deployment entities.
 */
public void testDeploymentEvents() throws Exception {
assertNotNull(deployment);
assertEquals(2,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(deployment.getId(),((Deployment)event.getEntity()).getId());
assertTrue(listener.getEventsReceived().get(1) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(deployment.getId(),((Deployment)event.getEntity()).getId());
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(deployment.getId(),((Deployment)event.getEntity()).getId());
assertEquals("test",((Deployment)event.getEntity()).getCategory());
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiEntityEvent);
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(deployment.getId(),((Deployment)event.getEntity()).getId());
if (deployment != null && repositoryService.createDeploymentQuery().deploymentId(deployment.getId()).count() > 0) {
}
}