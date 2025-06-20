public void testOrQueryByprocessDefinition(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(6,historicprocessInstanceQuery.list().size());
assertEquals(6,historicprocessInstanceQuery.count());
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
assertEquals(deploymentId,processInstance.getDeploymentId());
assertNull(processInstance);
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().or().variableValueEquals("anothertest","invalid").processDefinitionName(PROCESS_DEFINITION_NAME_2).endOr().singleResult();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
assertEquals(PROCESS_DEFINITION_NAME_2,processInstance.getProcessDefinitionName());//RW
assertNull(processInstance);
processInstance=historyService.createHistoricProcessInstanceQuery().includeProcessVariables().or().variableValueEquals("anothertest","invalid").processDefinitionCategory(PROCESS_DEFINITION_CATEGORY_2).endOr().singleResult();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
assertNull(processInstance);
}
}