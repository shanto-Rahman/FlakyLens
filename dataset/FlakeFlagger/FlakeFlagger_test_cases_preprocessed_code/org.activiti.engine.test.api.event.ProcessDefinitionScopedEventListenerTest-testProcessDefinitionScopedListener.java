@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml","org/activiti/engine/test/api/event/simpleProcess.bpmn20.xml"}) public void testProcessDefinitionScopedListener() throws Exception {
assertNotNull(firstDefinition);
assertNotNull(firstDefinition);
assertNotNull(bpmnModel);
assertNotNull(processInstance);
assertFalse(listener.getEventsReceived().isEmpty());
assertNotNull(otherInstance);
assertTrue(listener.getEventsReceived().isEmpty());
}