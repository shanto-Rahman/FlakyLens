@Test public void testAsyncExecutorDisabledOnOneEngine(){
Assert.assertEquals(1,firstProcessEngine.getTaskService().createTaskQuery().taskName("The Task").count());
Assert.assertEquals(0,firstProcessEngine.getTaskService().createTaskQuery().taskName("Task after timer").count());
Assert.assertEquals(1,firstProcessEngine.getManagementService().createTimerJobQuery().count());
Assert.assertEquals(0,firstProcessEngine.getTaskService().createTaskQuery().taskName("The Task").count());
Assert.assertEquals(1,firstProcessEngine.getTaskService().createTaskQuery().taskName("Task after timer").count());
Assert.assertEquals(0,firstProcessEngine.getManagementService().createTimerJobQuery().count());
Assert.assertEquals(0,firstProcessEngine.getManagementService().createJobQuery().count());
Assert.assertEquals(0,getAsyncExecutorJobCount(firstProcessEngine));
Assert.assertEquals(1,getAsyncExecutorJobCount(secondProcessEngine));
}