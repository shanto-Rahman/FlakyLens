@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testHistoricDataCreatedForProcessExecution(){
assertEquals(1,historyService.createHistoricProcessInstanceQuery().unfinished().count());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().finished().count());
assertNotNull(historicProcessInstance);
assertEquals(processInstance.getId(),historicProcessInstance.getId());
assertEquals(processInstance.getBusinessKey(),historicProcessInstance.getBusinessKey());
assertEquals(processInstance.getProcessDefinitionId(),historicProcessInstance.getProcessDefinitionId());
assertEquals(noon,historicProcessInstance.getStartTime());
assertNull(historicProcessInstance.getEndTime());
assertNull(historicProcessInstance.getDurationInMillis());
assertEquals(1,tasks.size());
assertNotNull(historicProcessInstance);
assertEquals(processInstance.getId(),historicProcessInstance.getId());
assertEquals(processInstance.getProcessDefinitionId(),historicProcessInstance.getProcessDefinitionId());
assertEquals(noon,historicProcessInstance.getStartTime());
assertEquals(twentyFiveSecsAfterNoon,historicProcessInstance.getEndTime());
assertEquals(new Long(25 * 1000),historicProcessInstance.getDurationInMillis());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().unfinished().count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().finished().count());
}