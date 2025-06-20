@Test public void testLbUpdatesAfterEachDeployStep(){
Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(1,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
Assertions.assertTrue(taskManager.getCleanupTaskIds().contains(firstTask.getTaskId()));
Assertions.assertEquals(2,deployProgressStepOne.getTargetActiveInstances());
Assertions.assertEquals(2,pendingDeploy.getDeployProgress().getTargetActiveInstances());
Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
if (taskId.getInstanceNo() == 2) {
}
Assertions.assertEquals(DeployState.WAITING,pendingDeploy.getCurrentDeployState());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}