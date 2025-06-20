@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testHistoricVariableQuery() throws Exception {
assertEquals(2,historyService.createHistoricDetailQuery().variableUpdates().activityInstanceId(null).count());
assertEquals(0,historyService.createHistoricDetailQuery().variableUpdates().activityInstanceId("unexisting").count());
assertEquals(2,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId("unexisting").count());
assertEquals(2,historyService.createHistoricDetailQuery().variableUpdates().activityInstanceId(null).processInstanceId(processInstance.getId()).count());
assertEquals(1,tasks.size());
assertEquals(2,historyService.createHistoricVariableInstanceQuery().count());
assertEquals(2,historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricVariableInstanceQuery().processInstanceId("unexisting").count());
}