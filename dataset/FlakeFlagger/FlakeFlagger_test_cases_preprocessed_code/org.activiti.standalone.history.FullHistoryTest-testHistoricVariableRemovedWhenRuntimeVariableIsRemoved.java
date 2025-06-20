@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricVariableRemovedWhenRuntimeVariableIsRemoved() throws InterruptedException {
assertEquals(3,runtimeService.getVariables(processInstance.getId()).size());
assertEquals(3,runtimeService.getVariables(processInstance.getId(),Arrays.asList("var1","var2","var3")).size());
assertNotNull(runtimeService.getVariable(processInstance.getId(),"var2"));
assertEquals(3,historyService.createHistoricVariableInstanceQuery().list().size());
assertNotNull(historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).variableName("var2").singleResult());
assertEquals(3,details.size());
assertNotNull(((HistoricVariableUpdate)historicDetail).getValue());
Thread.sleep(800);
assertEquals(2,runtimeService.getVariables(processInstance.getId()).size());
assertEquals(2,runtimeService.getVariables(processInstance.getId(),Arrays.asList("var1","var2","var3")).size());
assertNull(runtimeService.getVariable(processInstance.getId(),"var2"));
assertEquals(2,historyService.createHistoricVariableInstanceQuery().list().size());
assertNull(historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).variableName("var2").singleResult());
assertEquals(4,details.size());
if (i != 3) {
assertNotNull(((HistoricVariableUpdate)details.get(i)).getValue());
if (i == 3) {
assertNull(((HistoricVariableUpdate)details.get(i)).getValue());
}
}
}