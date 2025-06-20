@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testNestedParallelCallActivityWithTimer.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.externalSubProcess.bpmn20.xml"}) public void testNestedParallelCallActivityWithTimer(){
assertEquals(4,tasks.size());
assertEquals("taskAfterTimer",taskAfterTimer.getTaskDefinitionKey());
}