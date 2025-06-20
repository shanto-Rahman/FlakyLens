@Deployment(resources={"org/activiti/examples/bpmn/executionlistener/ExecutionListenersForSubprocessStartEndEvent.bpmn20.xml"}) public void testExecutionListenersForSubprocessStartEndEvents(){
assertEquals(1,recordedEvents.size());
assertEquals("Process Start",recordedEvents.get(0).getParameter());
assertEquals(3,recordedEvents.size());
assertEquals("Subprocess Start",recordedEvents.get(0).getParameter());
assertEquals("Subprocess End",recordedEvents.get(1).getParameter());
assertEquals("Process End",recordedEvents.get(2).getParameter());
}