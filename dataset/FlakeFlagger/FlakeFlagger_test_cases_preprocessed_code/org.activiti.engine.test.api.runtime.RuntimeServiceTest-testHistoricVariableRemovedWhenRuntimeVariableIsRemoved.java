@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricVariableRemovedWhenRuntimeVariableIsRemoved(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(3,runtimeService.getVariables(processInstance.getId()).size());
assertEquals(3,runtimeService.getVariables(processInstance.getId(),Arrays.asList("var1","var2","var3")).size());
assertNotNull(runtimeService.getVariable(processInstance.getId(),"var2"));
assertEquals(3,historyService.createHistoricVariableInstanceQuery().list().size());
assertNotNull(historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).variableName("var2").singleResult());
assertEquals(2,runtimeService.getVariables(processInstance.getId()).size());
assertEquals(2,runtimeService.getVariables(processInstance.getId(),Arrays.asList("var1","var2","var3")).size());
assertNull(runtimeService.getVariable(processInstance.getId(),"var2"));
assertEquals(2,historyService.createHistoricVariableInstanceQuery().list().size());
assertNull(historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).variableName("var2").singleResult());
}
}