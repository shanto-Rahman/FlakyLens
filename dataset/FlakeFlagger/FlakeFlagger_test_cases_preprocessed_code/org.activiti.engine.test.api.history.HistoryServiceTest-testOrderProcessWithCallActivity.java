@Deployment(resources={"org/activiti/examples/bpmn/callactivity/orderProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/checkCreditProcess.bpmn20.xml"}) public void testOrderProcessWithCallActivity(){
assertEquals("Prepare and Ship",prepareAndShipTask.getName());
assertNotNull(historicProcessInstance);
assertTrue(historicProcessInstance.getProcessDefinitionId().contains("checkCreditProcess"));
}