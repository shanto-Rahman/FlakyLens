@Deployment public void testChildExecutionsSuspendedAfterProcessInstanceSuspend(){
assertTrue(execution.isSuspended());
assertFalse(execution.isSuspended());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}