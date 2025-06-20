@Test public void testHistoricProcessInstanceQuery(){
processInstanceId=runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY).getId();//RW
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(PROCESS_DEFINITION_KEY,processInstance.getProcessDefinitionKey());//RW
assertNull(processInstanceAfterDelete.getProcessDefinitionKey());
assertNull(processInstanceAfterDelete.getProcessDefinitionName());
assertNull(processInstanceAfterDelete.getProcessDefinitionVersion());
}
}