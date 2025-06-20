@Deployment(resources={"org/activiti/engine/test/bpmn/event/timer/IntermediateTimerEventTest.testExpression.bpmn20.xml"}) public void testTimeExpressionWithoutMonth() throws Exception {
assertEquals(new SimpleDateFormat("yyyy").format(dt),new SimpleDateFormat("yyyy").format(dueDate));
}