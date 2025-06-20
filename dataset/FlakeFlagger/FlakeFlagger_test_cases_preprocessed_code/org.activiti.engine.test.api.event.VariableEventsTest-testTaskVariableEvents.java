@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testTaskVariableEvents() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertEquals(3,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals("The value",event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_UPDATED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals("Updated value",event.getVariableValue());
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(task.getId(),event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals(null,event.getVariableValue());
}