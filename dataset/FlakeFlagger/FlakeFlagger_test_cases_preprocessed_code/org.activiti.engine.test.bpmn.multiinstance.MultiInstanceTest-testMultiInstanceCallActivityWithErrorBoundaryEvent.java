@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.callActivityWithBoundaryErrorEvent.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.throwingErrorEventSubProcess.bpmn20.xml"}) public void testMultiInstanceCallActivityWithErrorBoundaryEvent(){
assertEquals(2,tasks.size());
assertEquals(1,tasks.size());
assertEquals(0,processInstances.size());
}