public void testHistoricProcessInstanceQueryByProcessDefinitionVersion(){
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(1).list().get(0).getProcessDefinitionVersion().intValue());
assertEquals(2,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(2).list().get(0).getProcessDefinitionVersion().intValue());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(1).count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(2).count());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(3).count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(1).count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(2).list().size());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().processDefinitionVersion(3).list().size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,processInstance.getProcessDefinitionVersion().intValue());
assertEquals(123,variableMap.get("test"));
assertNull(processInstance);
assertEquals(2,processInstance.getProcessDefinitionVersion().intValue());
assertEquals(456,variableMap.get("anothertest"));
}
}