/** 
 * Test events related to error-events
 */
@Deployment public void testActivityErrorEvents() throws Exception {
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
assertEquals("myError",errorEvent.getErrorId());
assertEquals("123",errorEvent.getErrorCode());
assertEquals(processInstance.getId(),errorEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),errorEvent.getProcessDefinitionId());
assertFalse(processInstance.getId().equals(errorEvent.getExecutionId()));
}