@Deployment public void testDeleteHistoricProcessInstance(){
assertNotNull(processInstance);
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(3,historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(4,historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(4,historyService.createHistoricDetailQuery().processInstanceId(processInstance.getId()).count());
assertEquals(1,historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricDetailQuery().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstance.getId()).count());
fail("Exception expected when deleting process-instance that is still running");
}