/** 
 * Test variable events when done within a process (eg. execution-listener)
 */
@Deployment public void testTaskVariableEventsWithinProcess() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("variable",event.getVariableName());
assertEquals(123,event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_UPDATED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("variable",event.getVariableName());
assertEquals(456,event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("variable",event.getVariableName());
assertEquals(null,event.getVariableValue());
}