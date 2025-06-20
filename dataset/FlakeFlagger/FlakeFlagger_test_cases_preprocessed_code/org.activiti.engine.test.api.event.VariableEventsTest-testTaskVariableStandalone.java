/** 
 * Test to check create, update an delete behavior for variables on a task not related to a process.
 */
public void testTaskVariableStandalone() throws Exception {
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertNull(event.getProcessDefinitionId());
assertNull(event.getExecutionId());
assertNull(event.getProcessInstanceId());
assertEquals(newTask.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals(123,event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_UPDATED,event.getType());
assertNull(event.getProcessDefinitionId());
assertNull(event.getExecutionId());
assertNull(event.getProcessInstanceId());
assertEquals(newTask.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals(456,event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertNull(event.getProcessDefinitionId());
assertNull(event.getExecutionId());
assertNull(event.getProcessInstanceId());
assertEquals(newTask.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals(null,event.getVariableValue());
if (newTask.getId() != null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
}
}
}