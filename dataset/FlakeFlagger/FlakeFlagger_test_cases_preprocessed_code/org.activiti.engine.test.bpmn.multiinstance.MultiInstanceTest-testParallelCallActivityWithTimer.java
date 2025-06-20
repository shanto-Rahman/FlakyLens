@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelCallActivityWithTimer.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.externalSubProcess.bpmn20.xml"}) public void testParallelCallActivityWithTimer(){
assertEquals(6,tasks.size());
assertEquals("taskAfterTimer",taskAfterTimer.getTaskDefinitionKey());
}