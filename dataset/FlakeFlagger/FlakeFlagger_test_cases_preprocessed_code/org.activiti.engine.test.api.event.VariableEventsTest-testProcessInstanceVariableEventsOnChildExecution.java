/** 
 * Test create, update and delete variables locally on a child-execution of the process instance.
 */
@Deployment public void testProcessInstanceVariableEventsOnChildExecution() throws Exception {
assertNotNull(processInstance);
assertNotNull(child);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertEquals(child.getId(),event.getExecutionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
}