@Test public void testDeployOneInstanceAtATime(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(2)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  SingularityTask secondTask=launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.empty(),Optional.of(1),Optional.empty(),false);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(1,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  SingularityTaskId firstNewTaskId=taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).get(0);
  statusUpdate(taskManager.getTask(firstNewTaskId).get(),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(1,taskManager.getCleanupTaskIds().size());
  Assertions.assertTrue(taskManager.getCleanupTaskIds().contains(firstTask.getTaskId()));
  SingularityDeployProgress deployProgressStepOne=deployManager.getPendingDeploys().get(0).getDeployProgress();
  Assertions.assertEquals(2,deployProgressStepOne.getTargetActiveInstances());
  cleaner.drainCleanupQueue();
  statusUpdate(firstTask,TaskState.TASK_KILLED);
  deployChecker.checkDeploys();
  SingularityDeployProgress deployProgressStepTwo=deployManager.getPendingDeploys().get(0).getDeployProgress();
  Assertions.assertFalse(deployProgressStepTwo.isStepLaunchComplete());
  Assertions.assertEquals(2,deployProgressStepTwo.getTargetActiveInstances());
  scheduler.drainPendingQueue();
  Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}
