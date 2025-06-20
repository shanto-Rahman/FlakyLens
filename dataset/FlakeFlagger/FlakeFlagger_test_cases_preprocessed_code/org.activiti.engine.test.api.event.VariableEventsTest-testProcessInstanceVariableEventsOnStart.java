@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceVariableEventsOnStart() throws Exception {
assertNotNull(processInstance);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertEquals(processInstance.getProcessDefinitionId(),event.getProcessDefinitionId());
assertEquals(processInstance.getId(),event.getExecutionId());
assertEquals(processInstance.getId(),event.getProcessInstanceId());
assertNull(event.getTaskId());
assertEquals("testVariable",event.getVariableName());
assertEquals("The value",event.getVariableValue());
}