@Deployment(resources={"org/activiti/engine/test/bpmn/event/timer/IntermediateTimerEventTest.testExpression.bpmn20.xml"}) public void testTimeExpressionComplete() throws Exception {
assertEquals(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(dt),new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(dueDate));
}