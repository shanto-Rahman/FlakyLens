@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testTimerOnCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testTimerOnCallActivity(){
assertEquals("Task in subprocess",taskInSubProcess.getName());
assertEquals("Escalated Task",escalatedTask.getName());
assertEquals(0,runtimeService.createExecutionQuery().list().size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertTrue(historyService.createHistoricProcessInstanceQuery().processInstanceId(pi2.getId()).singleResult().getDeleteReason().startsWith(DeleteReason.BOUNDARY_EVENT_INTERRUPTING));
}
}