@Deployment public void testTerminateNestedMiEmbeddedSubprocessWithOneLoopCardinality(){
assertEquals(1,aTasks.size());
assertEquals(1,bTasks.size());
assertEquals(0,bTasks.size());
assertEquals(1,timers.size());
assertEquals(0,bTasks.size());
assertEquals(1,afterInnerMiTasks.size());
assertEquals(0,runtimeService.createExecutionQuery().count());
}