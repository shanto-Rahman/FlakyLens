@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessInstanceQueryOrderBy(){
assertTrue(historyService.createHistoricProcessInstanceQuery().count() == 0);
assertEquals(1,tasks.size());
}