@Deployment(resources={"org/activiti/examples/bpmn/executionlistener/ExecutionListenersFieldInjectionProcess.bpmn20.xml"}) public void testExecutionListenerFieldInjection(){
assertNotNull(varSetByListener);
assertTrue(varSetByListener instanceof String);
assertEquals("Yes, I am listening!",varSetByListener);
}