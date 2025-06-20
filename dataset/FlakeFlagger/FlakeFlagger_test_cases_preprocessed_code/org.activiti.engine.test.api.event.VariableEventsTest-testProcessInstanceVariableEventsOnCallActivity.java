@Deployment public void testProcessInstanceVariableEventsOnCallActivity() throws Exception {
assertNotNull(processInstance);
assertEquals(6,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertTrue(variableList.contains(event.getVariableName()));
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertTrue(variableList.contains(event.getVariableName()));
assertEquals(ActivitiEventType.VARIABLE_CREATED,event.getType());
assertTrue(variableList.contains(event.getVariableName()));
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertEquals(ActivitiEventType.VARIABLE_DELETED,event.getType());
assertEquals(0,variableList.size());
}