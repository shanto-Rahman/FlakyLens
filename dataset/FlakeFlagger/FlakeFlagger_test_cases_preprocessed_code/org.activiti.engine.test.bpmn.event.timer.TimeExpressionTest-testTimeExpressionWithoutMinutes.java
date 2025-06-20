@Deployment(resources={"org/activiti/engine/test/bpmn/event/timer/IntermediateTimerEventTest.testExpression.bpmn20.xml"}) public void testTimeExpressionWithoutMinutes() throws Exception {
assertEquals(new SimpleDateFormat("yyyy-MM-dd'T'HH").format(dt),new SimpleDateFormat("yyyy-MM-dd'T'HH").format(dueDate));
}