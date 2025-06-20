@Deployment(resources={"org/activiti/engine/test/bpmn/event/compensate/CompensateEventTest.testCallActivityCompensationHandler.bpmn20.xml","org/activiti/engine/test/bpmn/event/compensate/CompensationHandler.bpmn20.xml"}) public void testCallActivityCompensationHandler(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(5,historyService.createHistoricActivityInstanceQuery().activityId("undoBookHotel").count());
}
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(6,historyService.createHistoricProcessInstanceQuery().count());
}
}