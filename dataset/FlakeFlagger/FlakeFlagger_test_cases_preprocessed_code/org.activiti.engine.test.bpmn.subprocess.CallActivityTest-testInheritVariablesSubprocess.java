public void testInheritVariablesSubprocess() throws Exception {
BpmnModel mainBpmnModel=loadBPMNModel(INHERIT_VARIABLES_MAIN_PROCESS_RESOURCE);//RW
BpmnModel childBpmnModel=loadBPMNModel(INHERIT_VARIABLES_CHILD_PROCESS_RESOURCE);//RW
assertEquals(4,variableInstances.size());
assertEquals(variables.get(variable.getVariableName()),variable.getValue());
}