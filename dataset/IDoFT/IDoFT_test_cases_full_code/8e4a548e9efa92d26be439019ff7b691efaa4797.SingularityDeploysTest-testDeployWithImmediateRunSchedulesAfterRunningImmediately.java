@Test public void testDeployWithImmediateRunSchedulesAfterRunningImmediately(){
  initRequestWithType(RequestType.SCHEDULED,false);
  String deployId="d1";
  SingularityRunNowRequest runNowRequest=new SingularityRunNowRequestBuilder().setMessage("Message").build();
  SingularityDeploy deploy=new SingularityDeployBuilder(requestId,deployId).setRunImmediately(Optional.of(runNowRequest)).setCommand(Optional.of("printenv > tmp.txt")).build();
  SingularityDeployRequest deployRequest=new SingularityDeployRequest(deploy,Optional.empty(),Optional.empty());
  deployResource.deploy(deployRequest,singularityUser);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  SingularityTaskId taskId=taskManager.getActiveTaskIdsForDeploy(requestId,deployId).get(0);
  SingularityTask task=taskManager.getTask(taskId).get();
  statusUpdate(task,TaskState.TASK_RUNNING);
  statusUpdate(task,TaskState.TASK_FINISHED);
  scheduler.drainPendingQueue();
  resourceOffers();
  Assertions.assertEquals(0,taskManager.getNumActiveTasks());
  Assertions.assertEquals(1,taskManager.getNumScheduledTasks());
}
