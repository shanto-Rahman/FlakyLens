@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testDeleteProcessInstance(){
assertEquals(1,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertEquals(0,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(deleteReason,historicTaskInstance.getDeleteReason());
assertNotNull(historicInstance);
assertEquals(deleteReason,historicInstance.getDeleteReason());
assertNotNull(historicInstance.getEndTime());
}
}