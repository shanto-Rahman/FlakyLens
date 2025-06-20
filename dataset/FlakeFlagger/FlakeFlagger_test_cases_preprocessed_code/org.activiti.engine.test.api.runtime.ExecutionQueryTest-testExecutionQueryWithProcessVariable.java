@Deployment(resources={"org/activiti/engine/test/api/runtime/concurrentExecution.bpmn20.xml"}) public void testExecutionQueryWithProcessVariable(){
assertEquals(3,concurrentExecutions.size());
if (!((ExecutionEntity)execution).isProcessInstanceType()) {
}
assertEquals(2,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).variableValueEquals("x","child").count());
assertEquals(1,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).variableValueEquals("x","parent").count());
assertEquals(3,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueEquals("x","parent").count());
assertEquals(3,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueNotEquals("x","xxx").count());
assertEquals(0,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueEquals("child").count());
assertEquals(3,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueEquals("parent").count());
assertEquals(0,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueEqualsIgnoreCase("xIgnoreCase","CHILD").count());
assertEquals(3,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueEqualsIgnoreCase("xIgnoreCase","PARENT").count());
assertEquals(0,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueNotEqualsIgnoreCase("xIgnoreCase","paRent").count());
assertEquals(3,runtimeService.createExecutionQuery().processInstanceId(pi.getId()).processVariableValueNotEqualsIgnoreCase("xIgnoreCase","chilD").count());
}