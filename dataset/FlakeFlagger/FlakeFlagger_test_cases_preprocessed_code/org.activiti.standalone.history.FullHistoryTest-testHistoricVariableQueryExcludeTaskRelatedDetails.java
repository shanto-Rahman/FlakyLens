@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testHistoricVariableQueryExcludeTaskRelatedDetails() throws Exception {
assertNotNull(task);
assertEquals(3,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId(processInstance.getId()).count());
assertEquals(2,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId(processInstance.getId()).excludeTaskDetails().count());
assertEquals(1,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId(processInstance.getId()).excludeTaskDetails().taskId(task.getId()).count());
}