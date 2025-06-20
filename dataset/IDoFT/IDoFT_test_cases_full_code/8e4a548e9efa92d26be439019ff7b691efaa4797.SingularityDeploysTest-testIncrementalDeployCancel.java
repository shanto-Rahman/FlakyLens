@Test public void testIncrementalDeployCancel(){
  initRequest();
  SingularityRequest request=requestResource.getRequest(requestId,singularityUser).getRequest();
  requestResource.postRequest(request.toBuilder().setInstances(Optional.of(2)).build(),singularityUser);
  initFirstDeploy();
  SingularityTask firstTask=launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  launchTask(request,firstDeploy,2,TaskState.TASK_RUNNING);
  deploy(secondDeployId,Optional.<Boolean>empty(),Optional.of(1),Optional.<Boolean>empty(),false);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  SingularityTaskId firstNewTaskId=taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).get(0);
  statusUpdate(taskManager.getTask(firstNewTaskId).get(),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  cleaner.drainCleanupQueue();
  statusUpdate(firstTask,TaskState.TASK_KILLED);
  deployChecker.checkDeploys();
  scheduler.drainPendingQueue();
  resourceOffers();
  deployResource.cancelDeploy(singularityUser,requestId,secondDeployId);
  deployChecker.checkDeploys();
  Assertions.assertEquals(taskManager.getCleanupTasks().get(0).getCleanupType(),TaskCleanupType.INCREMENTAL_DEPLOY_CANCELLED);
  cleaner.drainCleanupQueue();
  Assertions.assertTrue(taskManager.getKilledTaskIdRecords().isEmpty());
  Assertions.assertEquals(taskManager.getCleanupTasks().get(0).getCleanupType(),TaskCleanupType.INCREMENTAL_DEPLOY_CANCELLED);
  launchTask(request,firstDeploy,1,TaskState.TASK_RUNNING);
  cleaner.drainCleanupQueue();
  Assertions.assertFalse(taskManager.getKilledTaskIdRecords().isEmpty());
}
