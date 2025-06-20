/** 
 * Timer repetition
 */
@Deployment public void testRepetitionJobEntityEvents() throws Exception {
assertNotNull(theJob);
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertEquals(ActivitiEventType.TIMER_SCHEDULED,event.getType());
assertEquals(0,listener.getEventsReceived().size());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(processInstance.getId()).count());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(processInstance.getId()).count());
assertTrue(firstTimerInstance.getId() != secondTimerInstance.getId());
assertEquals(0,managementService.createTimerJobQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,managementService.createTimerJobQuery().processInstanceId(processInstance.getId()).count());
}