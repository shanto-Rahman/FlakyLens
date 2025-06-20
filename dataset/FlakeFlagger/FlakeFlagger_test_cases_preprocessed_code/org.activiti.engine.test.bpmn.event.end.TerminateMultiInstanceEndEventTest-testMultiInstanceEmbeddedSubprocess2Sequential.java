@Deployment public void testMultiInstanceEmbeddedSubprocess2Sequential(){
assertEquals(1,bTasks.size());
assertEquals(2,tasks.size());
assertEquals("C",tasks.get(0).getName());
assertEquals("D",tasks.get(1).getName());
assertEquals("AfterMi",afterMiTask.getName());
assertEquals(0,runtimeService.createExecutionQuery().count());
}