public void testHistoricProcessInstanceOrQueryByProcessDefinitionVersion(){
assertEquals(1,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(1).processDefinitionId("undefined").endOr().count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(2).processDefinitionId("undefined").endOr().count());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(3).processDefinitionId("undefined").endOr().count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(1).processDefinitionId("undefined").endOr().list().size());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(2).processDefinitionId("undefined").endOr().list().size());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().or().processDefinitionVersion(3).processDefinitionId("undefined").endOr().list().size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,processInstance.getProcessDefinitionVersion().intValue());
assertEquals(123,variableMap.get("test"));
assertEquals(2,processInstance.getProcessDefinitionVersion().intValue());
assertEquals(456,variableMap.get("anothertest"));
assertNull(processInstance);
}
}