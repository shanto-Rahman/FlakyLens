@Deployment public void testTaskListenerDelegateExpression(){
assertEquals("task1-complete",runtimeService.getVariable(processInstance.getId(),"calledInExpression"));
assertEquals("task2-notify",runtimeService.getVariable(processInstance.getId(),"calledThroughNotify"));
}