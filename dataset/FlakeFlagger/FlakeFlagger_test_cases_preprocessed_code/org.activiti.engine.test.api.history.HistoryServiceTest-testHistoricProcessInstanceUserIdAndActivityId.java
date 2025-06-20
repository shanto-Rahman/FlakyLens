@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessInstanceUserIdAndActivityId(){
assertEquals("johndoe",historicProcessInstance.getStartUserId());
assertEquals("theStart",historicProcessInstance.getStartActivityId());
assertEquals(1,tasks.size());
assertEquals("theEnd",historicProcessInstance.getEndActivityId());
}