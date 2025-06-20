@Deployment(resources={"org/activiti/examples/bpmn/callactivity/orderProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/checkCreditProcess.bpmn20.xml"}) public void testOrderProcessWithCallActivity(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("Verify credit history",verifyCreditTask.getName());
assertNotNull(subProcessInstance);
assertEquals(pi.getId(),runtimeService.createProcessInstanceQuery().subProcessInstanceId(subProcessInstance.getId()).singleResult().getId());
assertEquals("Prepare and Ship",prepareAndShipTask.getName());
}
}