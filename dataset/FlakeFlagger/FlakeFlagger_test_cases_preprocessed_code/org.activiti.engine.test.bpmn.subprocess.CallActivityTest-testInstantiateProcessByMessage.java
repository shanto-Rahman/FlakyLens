public void testInstantiateProcessByMessage() throws Exception {
BpmnModel messageTriggeredBpmnModel=loadBPMNModel(MESSAGE_TRIGGERED_PROCESS_RESOURCE);//RW
assertNotNull(childProcessInstance);
}