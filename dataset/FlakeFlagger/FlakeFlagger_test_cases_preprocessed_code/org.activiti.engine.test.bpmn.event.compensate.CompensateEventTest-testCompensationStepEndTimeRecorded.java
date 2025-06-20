@Deployment(resources={"org/activiti/engine/test/bpmn/event/compensate/CompensateEventTest.testCompensationStepEndRecorded.bpmn20.xml"}) public void testCompensationStepEndTimeRecorded(){
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,query.count());
assertNotNull(compensationScriptTask);
assertNotNull(compensationScriptTask.getEndTime());
assertNotNull(compensationScriptTask.getDurationInMillis());
}
}