/** 
 * Test create, update and delete events of jobs entities.
 */
@Deployment public void testJobEntityEventsException() throws Exception {
assertNotNull(theJob);
fail("Expected exception");
assertNotNull(theJob);
assertEquals(8,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.TIMER_FIRED,event.getType());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(ActivitiEventType.JOB_EXECUTION_FAILURE,event.getType());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(ActivitiEventType.JOB_RETRIES_DECREMENTED,event.getType());
assertEquals(0,((Job)((ActivitiEntityEvent)event).getEntity()).getRetries());
}