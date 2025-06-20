/** 
 * Test events related to error-events, thrown from within process-execution (eg. service-task).
 */
@Deployment public void testActivityErrorEventsFromBPMNError() throws Exception {
assertNotNull(processInstance);
assertNull(afterErrorInstance);
if (event instanceof ActivitiErrorEvent) {
if (errorEvent == null) {
fail("Only one ActivityErrorEvent expected");
}
}
assertNotNull(errorEvent);
assertEquals(ActivitiEventType.ACTIVITY_ERROR_RECEIVED,errorEvent.getType());
assertEquals("catchError",errorEvent.getActivityId());
assertEquals("23",errorEvent.getErrorId());
assertEquals("23",errorEvent.getErrorCode());
assertEquals(processInstance.getId(),errorEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),errorEvent.getProcessDefinitionId());
assertFalse(processInstance.getId().equals(errorEvent.getExecutionId()));
}