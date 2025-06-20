@Test public void testScaleDownDuringDeploy(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(2)).build(),singularityUser);
  initFirstDeploy();
  launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  deploy(secondDeployId);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(1)).build(),singularityUser);
  scheduler.drainPendingQueue();
  Assertions.assertEquals(1,taskManager.getCleanupTaskIds().size());
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(2,taskManager.getCleanupTaskIds().size());
  scheduler.drainPendingQueue();
  Assertions.assertEquals(3,taskManager.getCleanupTaskIds().size());
}
