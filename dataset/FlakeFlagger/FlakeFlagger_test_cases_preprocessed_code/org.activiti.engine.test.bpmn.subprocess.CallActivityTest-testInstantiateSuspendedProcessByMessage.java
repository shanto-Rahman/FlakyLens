public void testInstantiateSuspendedProcessByMessage() throws Exception {
BpmnModel messageTriggeredBpmnModel=loadBPMNModel(MESSAGE_TRIGGERED_PROCESS_RESOURCE);//RW
fail("Exception expected");
}