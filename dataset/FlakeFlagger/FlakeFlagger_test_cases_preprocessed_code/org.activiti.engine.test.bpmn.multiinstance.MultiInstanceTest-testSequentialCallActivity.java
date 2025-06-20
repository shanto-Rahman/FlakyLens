@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.externalSubProcess.bpmn20.xml"}) public void testSequentialCallActivity(){
assertEquals(2,tasks.size());
assertEquals("task one",tasks.get(0).getName());
assertEquals("task two",tasks.get(1).getName());
}