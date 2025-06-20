@Test public void testDeployClearsObsoleteScheduledTasks(){
  initRequest();
  initFirstDeploy();
  initSecondDeploy();
  SingularityPendingTaskId taskIdOne=new SingularityPendingTaskId(requestId,firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),1,PendingType.IMMEDIATE,System.currentTimeMillis());
  SingularityPendingTask taskOne=new SingularityPendingTaskBuilder().setPendingTaskId(taskIdOne).build();
  SingularityPendingTaskId taskIdTwo=new SingularityPendingTaskId(requestId,firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1),2,PendingType.IMMEDIATE,System.currentTimeMillis());
  SingularityPendingTask taskTwo=new SingularityPendingTaskBuilder().setPendingTaskId(taskIdTwo).build();
  SingularityPendingTaskId taskIdThree=new SingularityPendingTaskId(requestId,secondDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),1,PendingType.IMMEDIATE,System.currentTimeMillis());
  SingularityPendingTask taskThree=new SingularityPendingTaskBuilder().setPendingTaskId(taskIdThree).build();
  SingularityPendingTaskId taskIdFour=new SingularityPendingTaskId(requestId + "hi",firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),5,PendingType.IMMEDIATE,System.currentTimeMillis());
  SingularityPendingTask taskFour=new SingularityPendingTaskBuilder().setPendingTaskId(taskIdFour).build();
  taskManager.savePendingTask(taskOne);
  taskManager.savePendingTask(taskTwo);
  taskManager.savePendingTask(taskThree);
  taskManager.savePendingTask(taskFour);
  launchTask(request,secondDeploy,1,TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  List<SingularityPendingTaskId> pendingTaskIds=taskManager.getPendingTaskIds();
  Assertions.assertTrue(!pendingTaskIds.contains(taskIdOne));
  Assertions.assertTrue(!pendingTaskIds.contains(taskIdTwo));
  Assertions.assertTrue(pendingTaskIds.contains(taskIdThree));
  Assertions.assertTrue(pendingTaskIds.contains(taskIdFour));
}
