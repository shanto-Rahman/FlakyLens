@Deployment(resources={"org/activiti/engine/test/bpmn/event/timer/IntermediateTimerEventTest.testExpression.bpmn20.xml"}) public void testTimeExpressionWithoutDay() throws Exception {
assertEquals(new SimpleDateFormat("yyyy-MM").format(dt),new SimpleDateFormat("yyyy-MM").format(dueDate));
}