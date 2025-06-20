@Test public void testLbUpdatesAfterEachDeployStep(){
  initLoadBalancedRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(2)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  SingularityTask secondTask=launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.<Boolean>empty(),Optional.of(1),Optional.<Boolean>empty(),true);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(1,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  SingularityTaskId firstNewTaskId=taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).get(0);
  statusUpdate(taskManager.getTask(firstNewTaskId).get(),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  SingularityPendingDeploy pendingDeploy=deployManager.getPendingDeploy(requestId).get();
  Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
  testingLbClient.setNextRequestState(LoadBalancerRequestState.WAITING);
  deployChecker.checkDeploys();
  pendingDeploy=deployManager.getPendingDeploy(requestId).get();
  Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
  testingLbClient.setNextRequestState(LoadBalancerRequestState.SUCCESS);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertTrue(taskManager.getCleanupTaskIds().contains(firstTask.getTaskId()));
  pendingDeploy=deployManager.getPendingDeploy(requestId).get();
  SingularityDeployProgress deployProgressStepOne=pendingDeploy.getDeployProgress();
  Assertions.assertEquals(2,deployProgressStepOne.getTargetActiveInstances());
  cleaner.drainCleanupQueue();
  statusUpdate(firstTask,TaskState.TASK_KILLED);
  testingLbClient.setNextRequestState(LoadBalancerRequestState.WAITING);
  deployChecker.checkDeploys();
  pendingDeploy=deployManager.getPendingDeploy(requestId).get();
  Assertions.assertEquals(2,pendingDeploy.getDeployProgress().getTargetActiveInstances());
  scheduler.drainPendingQueue();
  Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
  resourceOffers();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  SingularityTaskId secondNewTaskId=null;
  for (  SingularityTaskId taskId : taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId)) {
    if (taskId.getInstanceNo() == 2) {
      secondNewTaskId=taskId;
    }
  }
  statusUpdate(taskManager.getTask(secondNewTaskId).get(),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  pendingDeploy=deployManager.getPendingDeploy(requestId).get();
  Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
  testingLbClient.setNextRequestState(LoadBalancerRequestState.SUCCESS);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
  Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}
