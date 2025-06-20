@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testDeleteProcessInstanceNullReason(){
assertEquals(1,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertEquals(0,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicInstance);
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historicInstance.getDeleteReason());
}
}