public void testNotInheritVariablesSubprocess() throws Exception {
BpmnModel mainBpmnModel=loadBPMNModel(NOT_INHERIT_VARIABLES_MAIN_PROCESS_RESOURCE);//RW
BpmnModel childBpmnModel=loadBPMNModel(INHERIT_VARIABLES_CHILD_PROCESS_RESOURCE);//RW
assertEquals(0,variableInstances.size());
}