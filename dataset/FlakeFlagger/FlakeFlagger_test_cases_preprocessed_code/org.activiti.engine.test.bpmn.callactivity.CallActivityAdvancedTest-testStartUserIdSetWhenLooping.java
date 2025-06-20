@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testStartUserIdSetWhenLooping.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testStartUserIdSetWhenLooping(){
assertEquals("Task in subprocess",task.getName());
assertEquals("Final task",task.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(3,historicProcessInstances.size());
assertNotNull(historicProcessInstance.getStartUserId());
assertNotNull(historicProcessInstance.getStartTime());
assertNotNull(historicProcessInstance.getEndTime());
}
}