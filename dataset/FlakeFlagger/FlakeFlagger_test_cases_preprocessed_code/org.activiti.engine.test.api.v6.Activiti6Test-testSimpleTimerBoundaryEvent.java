@Test @org.activiti.engine.test.Deployment public void testSimpleTimerBoundaryEvent(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals("Task after timer",task.getName());
assertEquals(0,runtimeService.createExecutionQuery().count());
}