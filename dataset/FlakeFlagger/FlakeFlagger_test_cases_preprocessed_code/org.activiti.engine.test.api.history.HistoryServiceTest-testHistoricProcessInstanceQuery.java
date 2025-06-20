@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessInstanceQuery(){
assertTrue(historyService.createHistoricProcessInstanceQuery().count() == 0);
assertTrue(historyService.createHistoricProcessInstanceQuery().count() == 1);
assertEquals(1,tasks.size());
assertTrue(historyService.createHistoricProcessInstanceQuery().count() == 1);
}