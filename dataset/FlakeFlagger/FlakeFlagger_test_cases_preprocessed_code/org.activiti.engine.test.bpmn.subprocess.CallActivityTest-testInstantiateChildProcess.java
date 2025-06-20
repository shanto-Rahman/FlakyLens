public void testInstantiateChildProcess() throws Exception {
BpmnModel childBpmnModel=loadBPMNModel(CHILD_PROCESS_RESOURCE);//RW
assertNotNull(childProcessInstance);
}