@Deployment(resources={"org/activiti/examples/bpmn/executionlistener/ExecutionListenersProcess.bpmn20.xml"}) public void testExecutionListenersOnAllPossibleElements(){
assertNotNull(varSetInExecutionListener);
assertEquals("firstValue",varSetInExecutionListener);
assertNotNull(businessKey);
assertEquals("businessKey123",businessKey);
assertNotNull(task);
assertNotNull(varSetInExecutionListener);
assertEquals("secondValue",varSetInExecutionListener);
assertNotNull(task);
assertNotNull(pojoVariable.getReceivedEventName());
assertEquals("end",pojoVariable.getReceivedEventName());
assertNotNull(task);
assertEquals(1,events.size());
assertEquals("End Process Listener",event.getParameter());
}