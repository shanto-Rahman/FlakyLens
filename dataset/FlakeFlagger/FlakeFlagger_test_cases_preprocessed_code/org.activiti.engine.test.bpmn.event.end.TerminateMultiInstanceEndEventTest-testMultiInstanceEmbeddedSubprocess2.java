@Deployment public void testMultiInstanceEmbeddedSubprocess2(){
assertEquals(5,bTasks.size());
assertEquals(6,tasks.size());
assertEquals("C",tasks.get(4).getName());
assertEquals("D",tasks.get(5).getName());
assertEquals("AfterMi",afterMiTask.getName());
assertEquals(0,runtimeService.createExecutionQuery().count());
}