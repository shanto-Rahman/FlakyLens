@Test @org.activiti.engine.test.Deployment public void testSimpleTimerBoundaryEventTimerDoesNotFire(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals("The famous task",task.getName());
assertEquals(0,managementService.createTimerJobQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
}