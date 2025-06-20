@Test public void testAsyncScriptExecution(){
Assert.assertEquals(0,processEngine.getManagementService().createJobQuery().count());
Assert.assertEquals(0,processEngine.getManagementService().createTimerJobQuery().count());
Assert.assertEquals(1,processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).count());
Assert.assertEquals(1,processEngine.getTaskService().createTaskQuery().taskName("Task after script").count());
Assert.assertEquals(1,getAsyncExecutorJobCount(processEngine));
}