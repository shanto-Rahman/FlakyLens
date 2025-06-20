@Test public void testDeployMultipleInstancesAtOnce(){
Assertions.assertEquals(2,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(2,taskManager.getCleanupTaskIds().size());
Assertions.assertTrue(cleanupTaskIds.contains(firstTask.getTaskId()) && cleanupTaskIds.contains(secondTask.getTaskId()));
Assertions.assertEquals(4,deployProgressStepOne.getTargetActiveInstances());
Assertions.assertFalse(deployProgressStepTwo.isStepLaunchComplete());
Assertions.assertEquals(4,deployProgressStepTwo.getTargetActiveInstances());
Assertions.assertEquals(2,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(4,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(4,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,secondDeployId).get().getDeployState());
}