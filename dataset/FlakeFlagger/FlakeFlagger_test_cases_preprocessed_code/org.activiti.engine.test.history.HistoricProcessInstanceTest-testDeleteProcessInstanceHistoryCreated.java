@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testDeleteProcessInstanceHistoryCreated(){
assertNotNull(processInstance);
assertNotNull(historicProcessInstance.getEndTime());
}