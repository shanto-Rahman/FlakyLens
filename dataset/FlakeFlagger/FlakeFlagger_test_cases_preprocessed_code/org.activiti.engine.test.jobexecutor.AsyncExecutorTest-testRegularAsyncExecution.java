@Test public void testRegularAsyncExecution(){
Assert.fail();
Assert.assertEquals(1,processEngine.getTaskService().createTaskQuery().taskName("The Task").count());
Assert.assertEquals(0,processEngine.getTaskService().createTaskQuery().taskName("Task after timer").count());
Assert.assertEquals(1,processEngine.getManagementService().createTimerJobQuery().count());
Assert.assertEquals(0,getAsyncExecutorJobCount(processEngine));
Assert.assertEquals(0,processEngine.getTaskService().createTaskQuery().taskName("The Task").count());
Assert.assertEquals(1,processEngine.getTaskService().createTaskQuery().taskName("Task after timer").count());
Assert.assertEquals(0,processEngine.getManagementService().createTimerJobQuery().count());
Assert.assertEquals(0,processEngine.getManagementService().createJobQuery().count());
Assert.assertEquals(1,getAsyncExecutorJobCount(processEngine));
if (processEngine != null) {
}
}