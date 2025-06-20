@Deployment public void testVariableScope(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals("test2",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("test2",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("test",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("test",runtimeService.getVariables(pi.getId()).get("test"));
assertEquals("test3",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("test3",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("test",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("test",runtimeService.getVariables(pi.getId()).get("test"));
assertEquals("test3",runtimeService.getVariable(subProcessTask.getExecutionId(),"test"));
assertEquals("test3",runtimeService.getVariables(subProcessTask.getExecutionId()).get("test"));
assertEquals("test4",runtimeService.getVariable(pi.getId(),"test"));
assertEquals("test4",runtimeService.getVariables(pi.getId()).get("test"));
}