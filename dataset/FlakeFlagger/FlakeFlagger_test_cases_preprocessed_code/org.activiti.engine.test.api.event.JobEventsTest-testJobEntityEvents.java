/** 
 * Test create, update and delete events of jobs entities.
 */
@Deployment public void testJobEntityEvents() throws Exception {
assertNotNull(theJob);
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.TIMER_SCHEDULED,event.getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_UPDATED,event.getType());
assertEquals(5,updatedJob.getRetries());
assertEquals(6,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.TIMER_FIRED,event.getType());
assertEquals(ActivitiEventType.ENTITY_DELETED,event.getType());
assertEquals(ActivitiEventType.JOB_EXECUTION_SUCCESS,event.getType());
}