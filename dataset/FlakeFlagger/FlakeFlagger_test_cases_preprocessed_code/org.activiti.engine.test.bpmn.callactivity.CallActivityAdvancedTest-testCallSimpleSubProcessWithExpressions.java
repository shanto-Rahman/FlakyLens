@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testCallSimpleSubProcessWithExpressions.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testCallSimpleSubProcessWithExpressions(){
assertEquals("Task before subprocess",taskBeforeSubProcess.getName());
assertEquals("Task in subprocess",taskInSubProcess.getName());
assertEquals("Task after subprocess",taskAfterSubProcess.getName());
}