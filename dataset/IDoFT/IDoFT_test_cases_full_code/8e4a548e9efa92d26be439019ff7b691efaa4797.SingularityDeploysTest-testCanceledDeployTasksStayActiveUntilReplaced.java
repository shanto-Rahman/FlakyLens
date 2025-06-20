@Test public void testCanceledDeployTasksStayActiveUntilReplaced(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(2)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  SingularityTask secondTask=launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.<Boolean>empty(),Optional.of(1),Optional.<Boolean>empty(),false);
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
  deployResource.cancelDeploy(singularityUser,requestId,secondDeployId);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  List<SingularityPendingTaskId> pendingTaskIds=taskManager.getPendingTaskIds();
  Assertions.assertEquals(1,pendingTaskIds.size());
  Assertions.assertEquals(firstDeployId,pendingTaskIds.get(0).getDeployId());
  cleaner.drainCleanupQueue();
  List<SingularityTaskId> cleanupTaskIds=taskManager.getCleanupTaskIds();
  Assertions.assertEquals(1,cleanupTaskIds.size());
  Assertions.assertEquals(secondDeployId,cleanupTaskIds.get(0).getDeployId());
  resourceOffers();
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,firstDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  cleaner.drainCleanupQueue();
  Assertions.assertEquals(0,taskManager.getCleanupTaskIds().size());
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,firstDeployId).size());
}
