@Test public void testDeployMultipleInstancesAtOnce(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(4)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  SingularityTask secondTask=launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  SingularityTask thirdTask=launchTask(request,firstDeploy,3,TaskState.TASK_RUNNING);
  SingularityTask fourthTask=launchTask(request,firstDeploy,4,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.<Boolean>empty(),Optional.of(2),Optional.<Boolean>empty(),false);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  Assertions.assertEquals(2,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(2,taskManager.getCleanupTaskIds().size());
  List<SingularityTaskId> cleanupTaskIds=taskManager.getCleanupTaskIds();
  Assertions.assertTrue(cleanupTaskIds.contains(firstTask.getTaskId()) && cleanupTaskIds.contains(secondTask.getTaskId()));
  SingularityDeployProgress deployProgressStepOne=deployManager.getPendingDeploys().get(0).getDeployProgress();
  Assertions.assertEquals(4,deployProgressStepOne.getTargetActiveInstances());
  cleaner.drainCleanupQueue();
  statusUpdate(firstTask,TaskState.TASK_KILLED);
  statusUpdate(secondTask,TaskState.TASK_KILLED);
  deployChecker.checkDeploys();
  SingularityDeployProgress deployProgressStepTwo=deployManager.getPendingDeploys().get(0).getDeployProgress();
  Assertions.assertFalse(deployProgressStepTwo.isStepLaunchComplete());
  Assertions.assertEquals(4,deployProgressStepTwo.getTargetActiveInstances());
  scheduler.drainPendingQueue();
  Assertions.assertEquals(2,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(4,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(4,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}
