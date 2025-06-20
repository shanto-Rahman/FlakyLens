@Deployment(resources={"org/activiti/examples/bpmn/callactivity/orderProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/checkCreditProcess.bpmn20.xml"}) public void testExcludeSubprocesses(){
assertNotNull(historicProcessInstance);
assertEquals(pi.getId(),historicProcessInstance.getId());
assertEquals(2,instanceList.size());
}