/** 
 * Test events related to compensation events.
 */
@Deployment public void testActivityCompensationEvents() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiActivityEvent);
assertEquals(ActivitiEventType.ACTIVITY_COMPENSATE,activityEvent.getType());
assertEquals("compensate",activityEvent.getActivityId());
assertFalse(processInstance.getId().equals(activityEvent.getExecutionId()));
assertEquals(processInstance.getProcessInstanceId(),activityEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),activityEvent.getProcessDefinitionId());
assertNotNull(processInstance);
}