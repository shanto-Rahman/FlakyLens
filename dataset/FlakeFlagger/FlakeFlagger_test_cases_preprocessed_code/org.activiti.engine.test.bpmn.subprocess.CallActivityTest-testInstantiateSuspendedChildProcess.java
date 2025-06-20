public void testInstantiateSuspendedChildProcess() throws Exception {
BpmnModel childBpmnModel=loadBPMNModel(CHILD_PROCESS_RESOURCE);//RW
fail("Exception expected");
}