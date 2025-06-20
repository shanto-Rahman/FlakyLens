@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessInstanceName(){
assertEquals(piName,historicProcessInstance.getName());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().processInstanceName(piName).list().size());
}