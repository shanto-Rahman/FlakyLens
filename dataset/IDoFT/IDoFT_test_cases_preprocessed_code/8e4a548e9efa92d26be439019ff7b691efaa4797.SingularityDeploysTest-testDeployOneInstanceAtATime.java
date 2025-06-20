@Test public void testDeployOneInstanceAtATime(){
Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(1,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(1,taskManager.getCleanupTaskIds().size());
Assertions.assertTrue(taskManager.getCleanupTaskIds().contains(firstTask.getTaskId()));
Assertions.assertEquals(2,deployProgressStepOne.getTargetActiveInstances());
Assertions.assertFalse(deployProgressStepTwo.isStepLaunchComplete());
Assertions.assertEquals(2,deployProgressStepTwo.getTargetActiveInstances());
Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}