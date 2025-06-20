public void testQueryByprocessDefinition(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
assertEquals(deploymentId,processInstance.getDeploymentId());
assertNull(processInstance);
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().variableValueEquals("anothertest",123).processDefinitionName(PROCESS_DEFINITION_NAME_2).singleResult();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
assertEquals(PROCESS_DEFINITION_NAME_2,processInstance.getProcessDefinitionName());//RW
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().variableValueEquals("test","test").processDefinitionName(PROCESS_DEFINITION_NAME_2).singleResult();//RW
assertNull(processInstance);
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().variableValueEquals("anothertest",123).processDefinitionCategory(PROCESS_DEFINITION_CATEGORY_2).singleResult();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().variableValueEquals("test","test").processDefinitionCategory(PROCESS_DEFINITION_CATEGORY_2).singleResult();//RW
assertNull(processInstance);
}
}