@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testCallSimpleSubProcess.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testCallSimpleSubProcess(){
assertEquals("Task before subprocess",taskBeforeSubProcess.getName());
assertEquals("Task in subprocess",taskInSubProcess.getName());
assertEquals("Task after subprocess",taskAfterSubProcess.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicProcess);
assertEquals("theStart",historicProcess.getStartActivityId());
assertEquals(3L,historicInstances.size());
assertTrue("Not all expected activities were found in the history",expectedActivities.isEmpty());
}
}