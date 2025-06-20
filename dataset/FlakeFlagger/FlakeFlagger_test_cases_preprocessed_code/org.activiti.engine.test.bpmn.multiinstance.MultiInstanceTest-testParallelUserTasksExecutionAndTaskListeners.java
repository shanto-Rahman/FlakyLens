@Deployment public void testParallelUserTasksExecutionAndTaskListeners(){
assertNotNull(waitState);
assertEquals(3,runtimeService.getVariable(processInstance.getId(),"taskListenerCounter"));
assertEquals(3,runtimeService.getVariable(processInstance.getId(),"executionListenerCounter"));
}