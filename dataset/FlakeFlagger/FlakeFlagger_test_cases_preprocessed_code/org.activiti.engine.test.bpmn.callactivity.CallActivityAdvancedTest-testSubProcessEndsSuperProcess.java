@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testSubProcessEndsSuperProcess.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testSubProcessEndsSuperProcess(){
assertEquals("Task in subprocess",taskBeforeSubProcess.getName());
assertEquals(0,runtimeService.createExecutionQuery().list().size());
}