public void testInstantiateSubprocess() throws Exception {
BpmnModel mainBpmnModel=loadBPMNModel(MAIN_PROCESS_RESOURCE);//RW
BpmnModel childBpmnModel=loadBPMNModel(CHILD_PROCESS_RESOURCE);//RW
fail("Exception expected");
}