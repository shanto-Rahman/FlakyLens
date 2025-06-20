@Deployment(resources={"org/activiti/examples/bpmn/executionlistener/CustomFlowExecutionListenerTest.bpmn20.xml"}) public void testScriptExecutionListener(){
assertNotNull(variable);
assertEquals("flow1_activiti_conditions",variable.getVariableName());
assertEquals(2,conditions.size());
assertEquals("hello",conditions.get(0));
assertEquals("world",conditions.get(1));
}