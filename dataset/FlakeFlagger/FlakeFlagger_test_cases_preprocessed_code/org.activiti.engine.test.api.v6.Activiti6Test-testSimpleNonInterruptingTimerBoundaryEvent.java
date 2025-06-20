@Test @org.activiti.engine.test.Deployment public void testSimpleNonInterruptingTimerBoundaryEvent(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(2,tasks.size());
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
}