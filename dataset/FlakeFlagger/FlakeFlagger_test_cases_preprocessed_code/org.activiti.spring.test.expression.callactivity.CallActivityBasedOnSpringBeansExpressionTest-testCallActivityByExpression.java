@Deployment(resources={"org/activiti/spring/test/expression/callactivity/CallActivityBasedOnSpringBeansExpressionTest.testCallActivityByExpression.bpmn20.xml","org/activiti/spring/test/expression/callactivity/simpleSubProcess.bpmn20.xml"}) public void testCallActivityByExpression() throws Exception {
assertEquals("Task before subprocess",taskBeforeSubProcess.getName());
assertEquals("Task in subprocess",taskInSubProcess.getName());
assertEquals("Task after subprocess",taskAfterSubProcess.getName());
}