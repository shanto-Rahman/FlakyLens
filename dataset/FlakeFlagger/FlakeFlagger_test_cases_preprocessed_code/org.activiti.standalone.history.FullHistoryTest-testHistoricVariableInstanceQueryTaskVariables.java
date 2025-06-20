@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testHistoricVariableInstanceQueryTaskVariables(){
assertEquals(1,historyService.createHistoricVariableInstanceQuery().count());
assertNotNull(activeTask);
assertEquals(2,historyService.createHistoricVariableInstanceQuery().count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().taskId(activeTask.getId()).count());
assertEquals("setFromTask",historyService.createHistoricVariableInstanceQuery().taskId(activeTask.getId()).singleResult().getValue());
assertEquals(activeTask.getId(),historyService.createHistoricVariableInstanceQuery().taskId(activeTask.getId()).singleResult().getTaskId());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().excludeTaskVariables().count());
fail("Exception expected");
assertEquals("taskId is null",ae.getMessage());
fail("Exception expected");
assertEquals("Cannot use taskId together with excludeTaskVariables",ae.getMessage());
fail("Exception expected");
assertEquals("Cannot use taskId together with excludeTaskVariables",ae.getMessage());
}