@Deployment public void testTerminateNestedMiEmbeddedSubprocess(){
assertEquals(12,aTasks.size());
assertEquals(72,bTasks.size());
assertEquals(72 - nrOfBTasksCompleted,bTasks.size());
assertEquals(nrOfBTasksCompleted,timers.size());
assertEquals(66,bTasks.size());
assertEquals(1,afterInnerMiTasks.size());
assertEquals(0,runtimeService.createExecutionQuery().count());
}