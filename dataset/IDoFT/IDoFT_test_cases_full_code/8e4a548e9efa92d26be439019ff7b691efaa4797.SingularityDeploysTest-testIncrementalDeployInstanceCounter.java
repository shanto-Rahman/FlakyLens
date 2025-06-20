@Test public void testIncrementalDeployInstanceCounter(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(4)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  SingularityTask secondTask=launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  SingularityTask thirdTask=launchTask(request,firstDeploy,3,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.<Boolean>empty(),Optional.of(1),Optional.<Boolean>empty(),false);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  SingularityTaskId firstNewTaskId=taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).get(0);
  statusUpdate(taskManager.getTask(firstNewTaskId).get(),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  SingularityDeployProgress deployProgress=deployManager.getPendingDeploy(requestId).get().getDeployProgress();
  Assertions.assertEquals(1,deployProgress.getTargetActiveInstances());
  Assertions.assertEquals(1,deployProgress.getCurrentActiveInstances());
  cleaner.drainCleanupQueue();
  statusUpdate(firstTask,TaskState.TASK_KILLED);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  deployChecker.checkDeploys();
  deployProgress=deployManager.getPendingDeploy(requestId).get().getDeployProgress();
  Assertions.assertEquals(2,deployProgress.getTargetActiveInstances());
  Assertions.assertEquals(2,deployProgress.getCurrentActiveInstances());
  cleaner.drainCleanupQueue();
  statusUpdate(secondTask,TaskState.TASK_KILLED);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    statusUpdate(taskManager.getTask(taskId).get(),TaskState.TASK_RUNNING);
  }
  deployChecker.checkDeploys();
  deployProgress=deployManager.getPendingDeploy(requestId).get().getDeployProgress();
  Assertions.assertEquals(3,deployProgress.getTargetActiveInstances());
  Assertions.assertEquals(3,deployProgress.getCurrentActiveInstances());
}
