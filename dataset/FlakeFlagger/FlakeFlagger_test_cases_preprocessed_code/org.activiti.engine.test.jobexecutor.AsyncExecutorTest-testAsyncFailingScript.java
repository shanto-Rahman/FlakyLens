@Test public void testAsyncFailingScript(){
if (timerJobCount == 0) {
}
Assert.assertEquals(0,processEngine.getTaskService().createTaskQuery().taskName("Task after script").count());
Assert.assertEquals(0,processEngine.getManagementService().createJobQuery().count());
Assert.assertEquals(1,processEngine.getManagementService().createDeadLetterJobQuery().count());
Assert.assertEquals(3,getAsyncExecutorJobCount(processEngine));
}