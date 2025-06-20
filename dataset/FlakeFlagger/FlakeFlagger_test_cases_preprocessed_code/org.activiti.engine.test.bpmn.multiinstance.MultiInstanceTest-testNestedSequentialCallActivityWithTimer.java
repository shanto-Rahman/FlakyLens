@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testNestedSequentialCallActivityWithTimer.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.externalSubProcess.bpmn20.xml"}) public void testNestedSequentialCallActivityWithTimer(){
assertEquals(2,tasks.size());
assertEquals("task one",tasks.get(0).getName());
assertEquals("task two",tasks.get(1).getName());
assertEquals(2,tasks.size());
assertEquals("taskAfterTimer",taskAfterTimer.getTaskDefinitionKey());
}