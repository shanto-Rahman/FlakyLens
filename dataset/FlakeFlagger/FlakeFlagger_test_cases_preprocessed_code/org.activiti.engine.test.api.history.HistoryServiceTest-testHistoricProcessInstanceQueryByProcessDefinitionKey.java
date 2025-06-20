@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/orderProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/checkCreditProcess.bpmn20.xml"}) public void testHistoricProcessInstanceQueryByProcessDefinitionKey(){
assertNotNull(historicProcessInstance);
assertTrue(historicProcessInstance.getProcessDefinitionKey().equals(processDefinitionKey));
assertEquals("theStart",historicProcessInstance.getStartActivityId());
assertEquals(historicProcessInstanceSuper.getId(),historicProcessInstanceSub.getSuperProcessInstanceId());
}