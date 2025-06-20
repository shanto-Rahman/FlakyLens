@Deployment(resources={"org/activiti/engine/test/api/oneSubProcess.bpmn20.xml"}) public void testRemoveVariableLocalWithParentScope(){
assertEquals("local value",runtimeService.getVariableLocal(currentTask.getExecutionId(),"localVariable"));
assertNull(runtimeService.getVariable(currentTask.getExecutionId(),"localVariable"));
assertNull(runtimeService.getVariableLocal(currentTask.getExecutionId(),"localVariable"));
assertEquals("value1",runtimeService.getVariable(processInstance.getId(),"variable1"));
assertEquals("value2",runtimeService.getVariable(processInstance.getId(),"variable2"));
assertEquals("value1",runtimeService.getVariable(currentTask.getExecutionId(),"variable1"));
assertEquals("value2",runtimeService.getVariable(currentTask.getExecutionId(),"variable2"));
}