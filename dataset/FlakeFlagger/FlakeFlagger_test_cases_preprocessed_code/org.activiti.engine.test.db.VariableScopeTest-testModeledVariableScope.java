@Deployment public void testModeledVariableScope(){
assertEquals("Task in subprocess1",subProcessTask.getName());
assertEquals("test2",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("test2",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("test",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("test",runtimeService.getVariables(pi.getId()).get("test"));
assertEquals("testX",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("testX",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("test",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("test",runtimeService.getVariables(pi.getId()).get("test"));
assertEquals("testX",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("testX",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("testY",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("testY",runtimeService.getVariables(pi.getId()).get("test"));
if (subProcTask.getName().equals("Task in subprocess2")) {
assertEquals("test3",runtimeService.getVariable(subProcTask.getExecutionId(),"test"));
assertEquals("test3",runtimeService.getVariables(subProcTask.getExecutionId()).get("test"));
assertEquals("testY",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("testY",runtimeService.getVariables(pi.getId()).get("test"));
if (subProcTask.getName().equals("Task in subprocess3")) {
assertEquals("test4",runtimeService.getVariable(subProcTask.getExecutionId(),"test"));
assertEquals("test4",runtimeService.getVariables(subProcTask.getExecutionId()).get("test"));
assertEquals("testY",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("testY",runtimeService.getVariables(pi.getId()).get("test"));
fail("Unexpected subProcessTask: " + subProcTask);
}
}
}