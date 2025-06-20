public void testProcessDefinitionIntrospection(){
assertEquals(procDefId,processDefinition.getId());
assertEquals("Process One",processDefinition.getName());
assertNotNull(startElement);
assertEquals("start",startElement.getId());
assertEquals("S t a r t",startElement.getName());
assertEquals("the start event",startElement.getDocumentation());
assertEquals(1,outgoingFlows.size());
assertEquals("${a == b}",outgoingFlows.get(0).getConditionExpression());
assertNotNull(endElement);
assertEquals("end",endElement.getId());
assertEquals("flow1",outgoingFlows.get(0).getId());
assertEquals("Flow One",outgoingFlows.get(0).getName());
assertEquals("The only transitions in the process",outgoingFlows.get(0).getDocumentation());
assertSame(startElement,outgoingFlows.get(0).getSourceFlowElement());
assertSame(endElement,outgoingFlows.get(0).getTargetFlowElement());
}