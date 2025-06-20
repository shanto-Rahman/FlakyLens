@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.callActivityWithBoundaryErrorEventSequential.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.throwingErrorEventSubProcess.bpmn20.xml"}) public void testSequentialMultiInstanceCallActivityWithErrorBoundaryEvent(){
assertEquals(1,tasks.size());
assertEquals(1,tasks.size());
assertEquals(0,processInstances.size());
}